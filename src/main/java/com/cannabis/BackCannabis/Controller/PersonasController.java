package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.PersonasDtos;
import com.cannabis.BackCannabis.Services.IServices.IPersonasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/personas")
public class PersonasController {

    @Autowired
    private IPersonasServices services;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public List<PersonasDtos> listarPersonas(){
        return services.FindAllS();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public PersonasDtos listarPersonasId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    USADO: PC
    @PostMapping("/")
    public ResponseEntity<PersonasDtos> guardarPersonas(@RequestBody PersonasDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonasDtos> actualizarPersonas(@RequestBody PersonasDtos dtos, @PathVariable("id") Long id){
        PersonasDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoPersonas(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("Persona eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogicamentePersonas(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("Persona eliminado logicamente con exito", HttpStatus.OK);
    }

}
