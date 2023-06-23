package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Usuarios;
import com.cannabis.BackCannabis.Services.IServices.IUsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/usuarios")
public class UsuariosController extends ControllerGeneric<Usuarios> {

    @Autowired
    private IUsuariosServices usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Usuarios> crear(@RequestBody Usuarios c) {
        try {
            c.setEstUsuarios(true);
            c.setPasswordUsuarios(passwordEncoder.encode(c.getPasswordUsuarios()));
            return new ResponseEntity<>(usuarioService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
