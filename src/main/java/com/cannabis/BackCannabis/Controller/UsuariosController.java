package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Usuarios;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/usuarios")
public class UsuariosController extends ControllerGeneric<Usuarios> {
}
