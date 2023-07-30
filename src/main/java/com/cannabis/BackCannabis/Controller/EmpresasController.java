package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.EmpresasDtos;
import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Repository.IEmpresasRepository;
import com.cannabis.BackCannabis.Services.IServices.IEmpresasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cbd/empresas")
public class EmpresasController {

    @Autowired
    private IEmpresasServices services;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all/")
    public List<EmpresasDtos> listarEmpresas(){
        return services.FindAllS();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/id/{id}")
    public EmpresasDtos listarEmpresasId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save/")
    public ResponseEntity<EmpresasDtos> guardarEmpresas(@RequestBody EmpresasDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<EmpresasDtos> actualizarEmpresas(@RequestBody EmpresasDtos dtos, @PathVariable("id") Long id){
        EmpresasDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @DeleteMapping("/Definitivo/{id}")
//    public ResponseEntity<String> eliminarDefinitivoEmpresas(@PathVariable("id") Long id){
//        services.DeleteS(id);
//        return new ResponseEntity<>("Empresa eliminado definitivamente con exito", HttpStatus.OK);
//    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarLogicamenteEmpresas(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("Empresa eliminado logicamente con exito", HttpStatus.OK);
    }

//    USADO: PC
    @GetMapping("/name/{nombreEmpresa}")
    public EmpresasDtos listarEmpresasByNombreEmpresaActivo(@PathVariable("nombreEmpresa") String nombreEmpresa){
        return services.findByNombreEmpresaActivo(nombreEmpresa);
    }

}
