package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Cargos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/cargos")
public class CargosController extends ControllerGeneric<Cargos> {
}
