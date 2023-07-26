package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.InfoProductosDtos;
import com.cannabis.BackCannabis.Services.IServices.IInfoProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/infoProductos")
public class InfoProductosController {

    @Autowired
    private IInfoProductosServices services;

    @GetMapping("/")
    public List<InfoProductosDtos> listarInfoProductos(){
        return services.FindAllS();
    }

    @GetMapping("/{id}")
    public InfoProductosDtos listarInfoProductosId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<InfoProductosDtos> guardarInfoProductos(@RequestBody InfoProductosDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<InfoProductosDtos> actualizarInfoProductos(@RequestBody InfoProductosDtos dtos, @PathVariable("id") Long id){
        InfoProductosDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoInfoProductos(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("InfoProducto eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogicamenteInfoProductos(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("InfoProducto eliminado logicamente con exito", HttpStatus.OK);
    }

}
