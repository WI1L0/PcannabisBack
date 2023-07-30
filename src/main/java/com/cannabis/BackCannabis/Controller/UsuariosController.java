package com.cannabis.BackCannabis.Controller;

import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.NoticiasRespuestaDto;
import com.cannabis.BackCannabis.Dtos.Respuestas.UsuariosRespuestaDto;
import com.cannabis.BackCannabis.Dtos.UsuariosDtos;
import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Modelos.Roles;
import com.cannabis.BackCannabis.Modelos.Usuarios;
import com.cannabis.BackCannabis.Repository.IRolesRepository;
import com.cannabis.BackCannabis.Services.IServices.IEmpresasServices;
import com.cannabis.BackCannabis.Services.IServices.IRolesServices;
import com.cannabis.BackCannabis.Services.IServices.IUsuariosServices;
import com.cannabis.BackCannabis.utilerias.AppConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/cbd/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuariosServices services;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping("/all/{nombreEmpresa}")
//    public List<UsuariosDtos> listarUsuarios(@PathVariable String nombreEmpresa){
//        return services.FindAllS(nombreEmpresa);
//    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/id/{id}")
    public UsuariosDtos listarUsuariosId(@PathVariable("id") Long id){
        return services.FindByIdS(id);
    }

//    USADO: PC
    @PostMapping("/save/persona/{idPersona}/rol/{idRol}/empresa/{idEmpresa}")
    public ResponseEntity<UsuariosDtos> guardarUsuarios(@RequestBody UsuariosDtos dtos, @PathVariable("idPersona") Long idPersona, @PathVariable("idRol") String idRol, @PathVariable("idEmpresa") String nombreEmpresa){
        return new ResponseEntity<>(services.SaveS(dtos, idPersona, idRol, nombreEmpresa), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UsuariosDtos> actualizarUsuarios(@RequestBody UsuariosDtos dtos, @PathVariable("id") Long id){
        UsuariosDtos actualizado = services.UpdateS(id, dtos);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarLogicamenteUsuarios(@PathVariable("id") Long id){
        services.LogicoDeleteS(id);
        return new ResponseEntity<>("Usuario eliminado logicamente con exito", HttpStatus.OK);
    }

//    USADO: PC
    @PostMapping("/save/cliente/persona/{idPersona}/empresa/{idEmpresa}")
    public ResponseEntity<UsuariosDtos> guardarUsuariosRolCliente(@RequestBody UsuariosDtos dtos, @PathVariable("idPersona") Long idPersona, @PathVariable("idEmpresa") String nombreEmpresa){
        return new ResponseEntity<>(services.SaveClienteS(dtos, idPersona, nombreEmpresa), HttpStatus.CREATED);
    }

    @GetMapping("/all/paginacion/{nombreEmpresa}")
    public UsuariosRespuestaDto listarUsuariosPersonasPaginacion(@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
                                                                 @RequestParam(value = "pageSize", defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
                                                                 @RequestParam(value = "sortBy", defaultValue = AppConstantes.ORDENAR_POR_DEFECTO_USUARIO_PERSONA, required = false) String ordenarPor,
                                                                 @RequestParam(value = "sortDir", defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir,
                                                                 @PathVariable("nombreEmpresa") String nombreEmpresa){
        return services.FindAllPaginacionS(numeroDePagina, medidaDePagina, ordenarPor, sortDir, nombreEmpresa);
    }

    @GetMapping("/all/paginacion/busqueda/{nombreEmpresa}/{cedulaOrApellido1}")
    public UsuariosRespuestaDto buscarPorCedulaOrApellido1(@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
                                                                 @RequestParam(value = "pageSize", defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
                                                                 @RequestParam(value = "sortBy", defaultValue = AppConstantes.ORDENAR_POR_DEFECTO_USUARIO_PERSONA, required = false) String ordenarPor,
                                                                 @RequestParam(value = "sortDir", defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir,
                                                                 @PathVariable("nombreEmpresa") String nombreEmpresa, @PathVariable("cedulaOrApellido1") String cedulaOrApellido1){
        return services.FindByCedulaAndApellido1(numeroDePagina, medidaDePagina, ordenarPor, sortDir, nombreEmpresa, cedulaOrApellido1);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping("/empresa/{id}")
//    public List<UsuariosDtos> listarUsuariosPorEmpresaId(@PathVariable("id") Long id){
//        return services.FindAllByEmpresasId(id);
//    }

}
