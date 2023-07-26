package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.ProductosReservasDtos;
import com.cannabis.BackCannabis.Dtos.ReservasDtos;
import com.cannabis.BackCannabis.Services.IServices.IProductosReservasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/productosReservas")
public class ProductosReservasController {

    @Autowired
    private IProductosReservasServices services;

    @GetMapping("/")
    public List<ProductosReservasDtos> listarProductosReservasDtos(){
        return services.FindAllS();
    }

    @GetMapping("/{id}")
    public ProductosReservasDtos listarProductosReservasDtosId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

    @PostMapping("/")
    public ResponseEntity<ProductosReservasDtos> guardarProductosReservasDtos(@RequestBody ProductosReservasDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosReservasDtos> actualizarProductosReservasDtos(@RequestBody ProductosReservasDtos dtos, @PathVariable("id") Long id){
        ProductosReservasDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoProductosReservasDtos(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("ProductosReserva eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogicamenteProductosReservasDtos(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("ProductosReserva eliminado logicamente con exito", HttpStatus.OK);
    }

    @GetMapping("/productos/{id}")
    public List<ProductosReservasDtos> listarProductosReservasPorProductosId(@PathVariable("id") Long id){
        return services.FindAllByProductosId(id);
    }

    @GetMapping("/reservas/{id}")
    public List<ProductosReservasDtos> listarProductosReservasPorReservasId(@PathVariable("id") Long id){
        return services.FindAllByReservasId(id);
    }

}
