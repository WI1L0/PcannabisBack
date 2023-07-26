package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.NoticiasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.NoticiasRespuestaDto;
import com.cannabis.BackCannabis.Services.IServices.INoticiasServices;
import com.cannabis.BackCannabis.utilerias.AppConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/noticias")
public class NoticiasController {

    @Autowired
    private INoticiasServices services;

    @GetMapping("/id/{id}")
    public NoticiasDtos listarNoticiasId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save/{nombreEmpresa}")
    public ResponseEntity<NoticiasDtos> guardarNoticias(@RequestBody NoticiasDtos dtos, @PathVariable("nombreEmpresa") String nombreEmpresa){
        return new ResponseEntity<>(services.SaveS(dtos, nombreEmpresa), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<NoticiasDtos> actualizarNoticias(@RequestBody NoticiasDtos dtos, @PathVariable("id") Long id){
        NoticiasDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<NoticiasDtos> eliminarLogicamenteNoticias(@PathVariable("id") Long id){
        return new ResponseEntity<>(services.LogicoDeleteS(id), HttpStatus.OK);
    }

    @GetMapping("/all/paginacion/{nombreEmpresa}")
    public NoticiasRespuestaDto listarNoticiasPaginacion(@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
                                                         @RequestParam(value = "pageSize", defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
                                                         @RequestParam(value = "sortBy", defaultValue = AppConstantes.ORDENAR_POR_DEFECTO_NOTICIAS, required = false) String ordenarPor,
                                                         @RequestParam(value = "sortDir", defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir,
                                                         @RequestParam(value = "estado", defaultValue = AppConstantes.ACTIVO_DESCATIVO, required = false) String estado,
                                                         @PathVariable("nombreEmpresa") String nombreEmpresa){
        return services.FindAllPaginacionS(numeroDePagina, medidaDePagina, ordenarPor, sortDir, estado, nombreEmpresa);
    }

    @GetMapping("/all/paginacion/busqueda/{nombreEmpresa}/{tituloOrFecha}")
    public NoticiasRespuestaDto buscarPorTituloOFecha(@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
                                                         @RequestParam(value = "pageSize", defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
//                                                         @RequestParam(value = "sortBy", defaultValue = AppConstantes.ORDENAR_POR_DEFECTO_NOTICIAS, required = false) String ordenarPor,
//                                                         @RequestParam(value = "sortDir", defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir,
                                                         @RequestParam(value = "estado", defaultValue = AppConstantes.ACTIVO_DESCATIVO, required = false) String estado,
                                                         @PathVariable("nombreEmpresa") String nombreEmpresa, @PathVariable("tituloOrFecha") String tituloOrFecha){
        return services.FindByTituloAndFecha(numeroDePagina, medidaDePagina, estado, nombreEmpresa, tituloOrFecha);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/update/estado/{id}")
    public ResponseEntity<NoticiasDtos> actualizarNoticiasEstado(@PathVariable("id") Long id){
        return new ResponseEntity<>(services.updateEstado(id), HttpStatus.OK);
    }
}
