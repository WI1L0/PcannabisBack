package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.ProductosDtos;
import com.cannabis.BackCannabis.Dtos.ProductosRespuestaDto;
import com.cannabis.BackCannabis.Services.IServices.IProductosServices;
import com.cannabis.BackCannabis.utilerias.AppConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cbd/productos")
public class ProductosController {

    @Autowired
    private IProductosServices services;

    @GetMapping("/{id}")
    public ProductosDtos listarProductosId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<ProductosDtos> guardarProductos(@RequestBody ProductosDtos dtos){
        return new ResponseEntity<>(services.SaveS(dtos), HttpStatus.CREATED);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProductosDtos> actualizarProductos(@RequestBody ProductosDtos dtos, @PathVariable("id") Long id){
        ProductosDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/Definitivo/{id}")
    public ResponseEntity<String> eliminarDefinitivoProductos(@PathVariable("id") Long id){
        services.DeleteS(id);
        return new ResponseEntity<>("Producto eliminado definitivamente con exito", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogicamenteProductos(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("Producto eliminado logicamente con exito", HttpStatus.OK);
    }

    @GetMapping("/")
    public ProductosRespuestaDto listarProductosPaginacion(@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
                                                           @RequestParam(value = "pageSize", defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
                                                           @RequestParam(value = "sortBy", defaultValue = AppConstantes.ORDENAR_POR_DEFECTO_PRODUCTOS, required = false) String ordenarPor,
                                                           @RequestParam(value = "sortDir", defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir){
        return services.FindAllPaginacionS(numeroDePagina, medidaDePagina, ordenarPor, sortDir);
    }

    @GetMapping("/empresa/{id}")
    public List<ProductosDtos> listarProductosPorEmpresaId(@PathVariable("id") Long id){
        return services.FindAllByEmpresasId(id);
    }

}
