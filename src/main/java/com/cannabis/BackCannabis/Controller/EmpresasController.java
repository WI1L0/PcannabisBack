package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Repository.IEmpresasRepository;
import com.cannabis.BackCannabis.Services.IServices.IEmpresasServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/cbd/empresas")
public class EmpresasController extends ControllerGeneric<Empresas> {

    IEmpresasServices service;

//    @GetMapping("/ByName/{name}")
//    public Empresas getByName(@PathVariable String name) {
//        return service.findByNameEmpresas();
//    }

}
