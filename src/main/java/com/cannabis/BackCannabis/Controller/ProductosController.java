package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Productos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/productos")
public class ProductosController extends ControllerGeneric<Productos> {
}
