package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Empresas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/empresas")
public class EmpresasController extends ControllerGeneric<Empresas> {
}
