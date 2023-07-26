package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.CategoriasProductosDtos;
import com.cannabis.BackCannabis.Modelos.CategoriasProductos;
import com.cannabis.BackCannabis.Services.IServices.ICategoriasProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/categoriasProductos")
public class CategoriasProductosController {

    @Autowired
    private ICategoriasProductosServices services;

    @GetMapping("/")
    public List<CategoriasProductosDtos> listarCategoriasProductos(){
        return services.FindAllS();
    }

    @GetMapping("/{id}")
    public CategoriasProductosDtos listarCategoriasProductosId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<CategoriasProductosDtos> guardarCategoriasProductos(@RequestBody CategoriasProductosDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriasProductosDtos> actualizarCategoriasProductos(@RequestBody CategoriasProductosDtos dtos, @PathVariable("id") Long id){
        CategoriasProductosDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoCategoriasProductos(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("CategoriasProducto eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogicamenteCategoriasProductos(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("CategoriasProducto eliminado logicamente con exito", HttpStatus.OK);
    }

}
