package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Empleados;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/empleados")
public class EmpleadosController extends ControllerGeneric<Empleados> {
}
