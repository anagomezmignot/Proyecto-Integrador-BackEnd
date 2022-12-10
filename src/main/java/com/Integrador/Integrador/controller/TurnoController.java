package com.Integrador.Integrador.controller;
import com.Integrador.Integrador.dto.TurnoDTO;
import com.Integrador.Integrador.exception.BadRequestException;
import com.Integrador.Integrador.exception.ResourceNotFoundException;
import com.Integrador.Integrador.service.OdontologoService;
import com.Integrador.Integrador.service.PacienteService;
import com.Integrador.Integrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


    @PostMapping
    public ResponseEntity<TurnoDTO> guardar (@RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        if (pacienteService.buscarPaciente(turnoDTO.getPacienteId()).isPresent() && odontologoService.buscarOdontologo(turnoDTO.getOdontologoId()).isPresent()){
            return ResponseEntity.ok(turnoService.guardarTurno(turnoDTO));
        }
        throw new BadRequestException("No se puede registrar un turno cuando no existe un odontologo y/o paciente");
    }

    @GetMapping("/buscar")
    public ResponseEntity<Optional<TurnoDTO>> buscar (@RequestParam("id") Long id) throws ResourceNotFoundException {
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()) {
            return ResponseEntity.ok(turnoService.buscarTurno(id));
        }
        throw new ResourceNotFoundException("No existe turno de id = " + id + " en la base de datos");
    }

    @PutMapping
    public ResponseEntity<String> actualizar (@RequestBody TurnoDTO turnoDTO) throws BadRequestException, ResourceNotFoundException {
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(turnoDTO.getId());
        if (turnoBuscado.isPresent()){
            if (pacienteService.buscarPaciente(turnoDTO.getPacienteId()).isPresent() && odontologoService.buscarOdontologo(turnoDTO.getOdontologoId()).isPresent()){
                turnoService.actualizarTurno(turnoDTO);
                return ResponseEntity.ok().body("Se actualizo el turno de id: " + turnoDTO.getId());
            }
            throw new BadRequestException("No se puede actualizar un turno cuando no existe un odontologo y/o paciente");
        }
        throw new ResourceNotFoundException("No existe turno de id = " + turnoDTO.getId() + " en la base de datos");
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<String> eliminar (@RequestParam("id") Long id) throws ResourceNotFoundException {
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok().body("Se elimino el turno de id: " + id);

        }
        throw new ResourceNotFoundException("No existe turno de id = " + id + " en la base de datos");
    }

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> buscarTodos () {
        return ResponseEntity.ok(turnoService.buscarTodosTurno());
    }

}
