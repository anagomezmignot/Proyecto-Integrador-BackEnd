package com.Integrador.Integrador.repository;

import com.Integrador.Integrador.modelo.Odontologo;
import com.Integrador.Integrador.modelo.Paciente;
import com.Integrador.Integrador.modelo.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {

    Optional<Set<Turno>> findByOdontologo(Odontologo odontologo);
    Optional<Set<Turno>> findByPaciente(Paciente paciente);

}
