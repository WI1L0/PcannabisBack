package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.FotosNoticiasDtos;
import com.cannabis.BackCannabis.Dtos.FotosProductosDtos;
import com.cannabis.BackCannabis.Modelos.FotosProductos;
import com.cannabis.BackCannabis.Services.IServices.IFotosProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/fotosProductos")
public class FotosProductosController {

    @Autowired
    private IFotosProductosServices services;

    @GetMapping("/")
    public List<FotosProductosDtos> listarFotosProductos(){
        return services.FindAllS();
    }

    @GetMapping("/{id}")
    public FotosProductosDtos listarFotosProductosId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<FotosProductosDtos> guardarFotosProductos(@RequestBody FotosProductosDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<FotosProductosDtos> actualizarFotosProductos(@RequestBody FotosProductosDtos dtos, @PathVariable("id") Long id){
        FotosProductosDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoFotosProductos(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("FotosProducto eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogicamenteFotosProductos(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("FotosProducto eliminado logicamente con exito", HttpStatus.OK);
    }

    @GetMapping("/noticia/{id}")
    public List<FotosProductosDtos> listarFotosProductosPorProductoId(@PathVariable("id") Long id){
        return services.FindAllByProductosId(id);
    }

}
