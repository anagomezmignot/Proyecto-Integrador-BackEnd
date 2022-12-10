package com.Integrador.Integrador.service;

import com.Integrador.Integrador.exception.BadRequestException;
import com.Integrador.Integrador.exception.ResourceNotFoundException;
import com.Integrador.Integrador.modelo.Odontologo;
import org.assertj.core.api.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
class OdontologoServiceTest {

    @Test
    void registrarOdontologo() {
    }

    
    @Test
    public void buscarOdontologoTest() throws BadRequestException {

    }

    @Test
    void listarOdontologos() {
    }

    @Test
    void actualizarOdontologo() {
    }


    @Test
    public void eliminarOdontologoTest() throws BadRequestException, ResourceNotFoundException {
        Odontologo odontologo = OdontologoService.registrarOdontologo(new Odontologo(12324, "aa123", "Ana","Mignot"));
            OdontologoService.eliminarOdontologo(odontologo.getId());
            assertThrows(BadRequestException.class, () -> OdontologoService.buscarOdontologo(odontologo.getId()), "No se encontró el odontólogo");
        }


}