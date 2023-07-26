package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.RolesDtos;
import com.cannabis.BackCannabis.Modelos.Roles;
import com.cannabis.BackCannabis.Services.IServices.IRolesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/roles")
public class RolesController {

    @Autowired
    private IRolesServices services;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public List<RolesDtos> listarRoles(){
        return services.FindAllS();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public RolesDtos listarRolesId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<RolesDtos> guardarRoles(@RequestBody RolesDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<RolesDtos> actualizarRoles(@RequestBody RolesDtos dtos, @PathVariable("id") Long id){
        RolesDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoRoles(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("Role eliminado definitivamente con exito", HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogicamenteRoles(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("Role eliminado logicamente con exito", HttpStatus.OK);
    }

}
