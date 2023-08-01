package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.NoticiasRespuestaDto;
import com.cannabis.BackCannabis.Dtos.Respuestas.UsuariosRespuestaDto;
import com.cannabis.BackCannabis.Dtos.UsuariosDtos;
import com.cannabis.BackCannabis.Modelos.Usuarios;

import java.util.List;

public interface IUsuariosServices {


//    CRUD
//    List<UsuariosDtos> FindAllS();
    UsuariosDtos FindByIdS(Long Id);
    UsuariosDtos SaveS(UsuariosDtos dtos, Long idPersona, String nombreRol, String nombreEmpresa);
    UsuariosDtos UpdateS(Long Id, UsuariosDtos dtos);
//    void DeleteS(Long Id);


//    CRUD MODIFICADO
    UsuariosDtos SaveClienteS(UsuariosDtos dtos, Long idPersona, String nombreEmpresa);
    UsuariosDtos LogicoDeleteS(Long Id);


//    PAGINACION
    UsuariosRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa);
    UsuariosRespuestaDto FindByCedulaAndApellido1(int numeroDePagina, int medidaDePagina, String estado, String nombreEmpresa, String celulaOrapellido1);

//    OTROS
    UsuariosDtos BloquearOrDesbloquearUsuarioS(Long Id);

//    TRAER TODO POR ATRIBUTO
//    List<UsuariosDtos> FindAllByEmpresasId(Long Id);
//    List<UsuariosDtos> FindAllByPersonasRU(Long Id);



}
