package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Roles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cbd/roles")
public class RolesController extends ControllerGeneric<Roles> {
}
