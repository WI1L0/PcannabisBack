package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Personas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/personas")
public class PersonasController extends ControllerGeneric<Personas> {
}
