package com.Integrador.Integrador.service;

import com.Integrador.Integrador.modelo.Odontologo;
import com.Integrador.Integrador.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private final IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository) { this.odontologoRepository = odontologoRepository; }
    public Odontologo registrarOdontologo(Odontologo odontologo) { return odontologoRepository.save(odontologo); }
    public Optional<Odontologo> buscarOdontologo(Long id) { return odontologoRepository.findById(id); }
    public List<Odontologo> listarOdontologos() { return odontologoRepository.findAll(); }
    public void actualizarOdontologo(Odontologo odontologo) { odontologoRepository.save(odontologo); }
    public void eliminarOdontologo(Long id) { odontologoRepository.deleteById(id); }

}
