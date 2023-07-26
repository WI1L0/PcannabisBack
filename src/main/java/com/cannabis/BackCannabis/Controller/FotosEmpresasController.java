package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.FotosEmpresasDtos;
import com.cannabis.BackCannabis.Services.IServices.IFotosEmpresasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/fotosEmpresas")
public class FotosEmpresasController {

    @Autowired
    private IFotosEmpresasServices services;

//    USADO: PC
    @GetMapping("/all/")
    public List<FotosEmpresasDtos> listarFotosEmpresas(){
        return services.FindAllS();
    }

    @GetMapping("/id/{id}")
    public FotosEmpresasDtos listarFotosEmpresasId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    USADO: PC
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save/")
    public ResponseEntity<FotosEmpresasDtos> guardarFotosEmpresas(@RequestBody FotosEmpresasDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<FotosEmpresasDtos> actualizarFotosEmpresas(@RequestBody FotosEmpresasDtos dtos, @PathVariable("id") Long id){
        FotosEmpresasDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoFotosEmpresas(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("FotosEmpresa eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarLogicamenteFotosEmpresas(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("FotosEmpresa eliminado logicamente con exito", HttpStatus.OK);
    }

//    @GetMapping("/empresa/{id}")
//    public List<FotosEmpresasDtos> listarFotosEmpresasPorEmpresaId(@PathVariable("id") Long id){
//        return services.FindAllByEmpresasId(id);
//    }

//    USADO: PC
    @GetMapping("/categoria/{categoria}")
    public List<FotosEmpresasDtos> listarFotosEmpresasPorCategoria(@PathVariable("categoria") String categoria){
        return services.FindAllByCategorias(categoria);
    }

}
