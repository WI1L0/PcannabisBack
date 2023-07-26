package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.FotosEmpresasDtos;
import com.cannabis.BackCannabis.Dtos.FotosNoticiasDtos;
import com.cannabis.BackCannabis.Modelos.FotosNoticias;
import com.cannabis.BackCannabis.Services.IServices.IFotosNoticiasServices;
import com.cannabis.BackCannabis.utilerias.AppConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/fotosNoticias")
public class FotosNoticiasController {

    @Autowired
    private IFotosNoticiasServices services;

//    USADO: PC
    @GetMapping("/all/")
    public List<FotosNoticiasDtos> listarFotosNoticias(){
        return services.FindAllS();
    }

    @GetMapping("/id/{id}")
    public FotosNoticiasDtos listarFotosNoticiasId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save/")
    public ResponseEntity<FotosNoticiasDtos> guardarFotosNoticias(@RequestBody FotosNoticiasDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<FotosNoticiasDtos> actualizarFotosNoticias(@RequestBody FotosNoticiasDtos dtos, @PathVariable("id") Long id){
        FotosNoticiasDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoFotosNoticias(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("FotosNoticia eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarLogicamenteFotosNoticias(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("FotosNoticia eliminado logicamente con exito", HttpStatus.OK);
    }
//    USADO: PC
    @GetMapping("/all/activo/")
    public List<FotosNoticiasDtos> listarFotosNoticiasActivo(){
        return services.FindAllSActivo();
    }

//    USADO: PC
    @GetMapping("/noticia/{id}")
    public List<FotosNoticiasDtos> listarFotosNoticiasPorNoticiaId(@PathVariable("id") Long id, @RequestParam(value = "estado", defaultValue = AppConstantes.ACTIVO_DESCATIVO, required = false) String estado){
        return services.FindAllByNoticiasId(id, estado);
    }

}
