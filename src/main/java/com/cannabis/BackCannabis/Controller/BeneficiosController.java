package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/beneficios")
public class BeneficiosController extends ControllerGeneric<Beneficios> {
}
