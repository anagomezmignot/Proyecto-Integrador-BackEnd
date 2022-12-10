package com.Integrador.Integrador.security;

import com.Integrador.Integrador.modelo.Usuario;
import com.Integrador.Integrador.modelo.UsuarioRole;
import com.Integrador.Integrador.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CargarDatosIniciales implements ApplicationRunner {

    private IUsuarioRepository usuarioRepository;
    @Autowired
    public CargarDatosIniciales(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //cargar un usuario para probar
        BCryptPasswordEncoder cifrador= new BCryptPasswordEncoder();
        String passCifrada=cifrador.encode("digital");
        Usuario usuario=new Usuario("Ana","Ani","anagomez@gmail.com",
                passCifrada, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario);
    }

}
