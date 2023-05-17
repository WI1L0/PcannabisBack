package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.CategoriasProductos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/categoriasProductos")
public class CategoriasProductosController extends ControllerGeneric<CategoriasProductos> {
}
