package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Reservas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/reservas")
public class ReservasController extends ControllerGeneric<Reservas> {
}
