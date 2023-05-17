package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Noticias;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/noticias")
public class NoticiasController extends ControllerGeneric<Noticias> {
}
