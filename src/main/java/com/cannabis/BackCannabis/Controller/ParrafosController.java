package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.FotosNoticiasDtos;
import com.cannabis.BackCannabis.Dtos.ParrafosDtos;
import com.cannabis.BackCannabis.Services.IServices.IParrafosServices;
import com.cannabis.BackCannabis.utilerias.AppConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/parrafos")
public class ParrafosController {

    @Autowired
    private IParrafosServices services;

//    USADO: PC
    @GetMapping("/all/")
    public List<ParrafosDtos> listarParrafos(){
        return services.FindAllS();
    }

    @GetMapping("/id/{id}")
    public ParrafosDtos listarParrafosId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save/")
    public ResponseEntity<ParrafosDtos> guardarParrafos(@RequestBody ParrafosDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ParrafosDtos> actualizarParrafos(@RequestBody ParrafosDtos dtos, @PathVariable("id") Long id){
        ParrafosDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoParrafos(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("Parrafo eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarLogicamenteParrafos(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("Parrafo eliminado logicamente con exito", HttpStatus.OK);
    }

//    USADO: PC
    @GetMapping("/noticia/{id}")
    public List<ParrafosDtos> listarParrafosPorNoticiaId(@PathVariable("id") Long id){
        return services.findByParrafosAll(id);
    }

}
