package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Repository.IEmpresasRepository;
import com.cannabis.BackCannabis.Services.IServices.IEmpresasServices;
import com.cannabis.BackCannabis.Services.ServicesImpl.EmpresasServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cbd/empresas")
public class EmpresasController extends ControllerGeneric<Empresas> {

    @Autowired
    private IEmpresasServices serviceEmpresa;

    @GetMapping("/ByName/{Nombreemp}")
    public Empresas getByName(@PathVariable("Nombreemp") String name) {
//        System.out.println(serviceEmpresa.findByNameEmpresas("SoinMed"));
        return serviceEmpresa.findByNameEmpresas(name);
    }

    @GetMapping("/abc")
    public List<Empresas> getAll() {
//        getByName();
        return serviceEmpresa.findByAll();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Empresas>> listaEmpresas() {
        return new ResponseEntity<>(serviceEmpresa.findByAll(), HttpStatus.OK);
    }

}
