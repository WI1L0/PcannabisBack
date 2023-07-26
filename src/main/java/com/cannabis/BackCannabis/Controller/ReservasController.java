package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.ReservasDtos;
import com.cannabis.BackCannabis.Modelos.Reservas;
import com.cannabis.BackCannabis.Services.IServices.IReservasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/reservas")
public class ReservasController {

    @Autowired
    private IReservasServices services;

    @GetMapping("/")
    public List<ReservasDtos> listarReservas(){
        return services.FindAllS();
    }

    @GetMapping("/{id}")
    public ReservasDtos listarReservasId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

    @PostMapping("/")
    public ResponseEntity<ReservasDtos> guardarReservas(@RequestBody ReservasDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservasDtos> actualizarReservas(@RequestBody ReservasDtos dtos, @PathVariable("id") Long id){
        ReservasDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoReservas(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("Reserva eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogicamenteReservas(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("Reserva eliminado logicamente con exito", HttpStatus.OK);
    }

    @GetMapping("/usuario/{id}")
    public List<ReservasDtos> listarReservasPorUsuarioId(@PathVariable("id") Long id){
        return services.FindAllByUsuarioId(id);
    }

}
