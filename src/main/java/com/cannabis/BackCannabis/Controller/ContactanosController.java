package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.ReservasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.ContactanosRespuestaDto;
import com.cannabis.BackCannabis.Dtos.Respuestas.NoticiasRespuestaDto;
import com.cannabis.BackCannabis.Dtos.Respuestas.UsuariosRespuestaDto;
import com.cannabis.BackCannabis.Services.IServices.IContactanosServices;
import com.cannabis.BackCannabis.utilerias.AppConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/contactanos")
public class ContactanosController {

    @Autowired
    private IContactanosServices services;

    @GetMapping("/")
    public List<ContactanosDtos> listarContactanos(){
        return services.FindAllS();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ContactanosDtos listarContactanosId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

    @PostMapping("/")
    public ResponseEntity<ContactanosDtos> guardarContactanos(@RequestBody ContactanosDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ContactanosDtos> actualizarContactanos(@RequestBody ContactanosDtos dtos, @PathVariable("id") Long id){
        ContactanosDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoContactanos(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("Contactano eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogicamenteContactanos(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("Contactano eliminado logicamente con exito", HttpStatus.OK);
    }

    //    USADO: PC
    @GetMapping("/all/paginacion/{nombreEmpresa}")
    public ContactanosRespuestaDto listarContactanosPaginacion(@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
                                                                 @RequestParam(value = "pageSize", defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
                                                                 @RequestParam(value = "sortBy", defaultValue = AppConstantes.ORDENAR_POR_DEFECTO_CONTACTANOS, required = false) String ordenarPor,
                                                                 @RequestParam(value = "sortDir", defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir,
                                                                 @RequestParam(value = "estado", defaultValue = AppConstantes.ACTIVO_DESCATIVO, required = false) String estado,
                                                                 @PathVariable("nombreEmpresa") String nombreEmpresa){
        return services.FindAllPaginacionS(numeroDePagina, medidaDePagina, ordenarPor, sortDir, estado, nombreEmpresa);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping("/empresa/{id}")
//    public List<ContactanosDtos> listarContactanosPorEmpresaId(@PathVariable("id") Long id){
//        return services.FindAllByEmpresasId(id);
//    }

}
