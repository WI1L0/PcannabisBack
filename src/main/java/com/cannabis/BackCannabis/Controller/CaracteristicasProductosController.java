package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.CaracteristicasProductos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/caracteristicasProductos")
public class CaracteristicasProductosController extends ControllerGeneric<CaracteristicasProductos> {
}
