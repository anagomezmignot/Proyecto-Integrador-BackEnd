package com.Integrador.Integrador.controller;

import com.Integrador.Integrador.modelo.Paciente;
import com.Integrador.Integrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscar-id/{id}")
    public ResponseEntity<Paciente> buscarPacienteById(@PathVariable("id") Long id) {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(id);
        ResponseEntity<Paciente> response;

        if (pacienteBuscado.isPresent()) {
            response = ResponseEntity.ok(pacienteBuscado.get());
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @GetMapping("/buscar-email/{email}")
    public ResponseEntity<Paciente> buscarPacienteByEmail(@PathVariable("email") String email) {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPacienteByEmail(email);
        ResponseEntity<Paciente> response;

        if (pacienteBuscado.isPresent()) {
            response = ResponseEntity.ok(pacienteBuscado.get());
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> mostrarPacientes() {
        return ResponseEntity.ok(pacienteService.buscarTodosPacientes());
    }

    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @PutMapping
    public ResponseEntity<String> actualizarPaciente(@RequestBody Paciente paciente){
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(paciente.getId());
        ResponseEntity<String> response;

        if (pacienteBuscado.isPresent()) {
            pacienteService.actualizarPaciente(paciente);
            response = ResponseEntity.ok("Se actualizó el paciente con apellido " + paciente.getApellido());
        } else {
            response = ResponseEntity.badRequest().body("El paciente con id= " + paciente.getId() + " no existe en la base de datos");
        }
        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(id);
        ResponseEntity<String> response;

        if (pacienteBuscado.isPresent()) {
            pacienteService.eliminarPaciente(pacienteBuscado.get().getId());
            response = ResponseEntity.ok().body("El paciente fue eliminado");
        } else {
            response = ResponseEntity.badRequest().body("No se puede eliminar al paciente con id=" + id + ", ya que el mismo no existe en la base de datos");
        }
        return response;
    }

}
