package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.CategoriasProductosDtos;
import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.ReservasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.ContactanosRespuestaDto;
import com.cannabis.BackCannabis.Dtos.Respuestas.NoticiasRespuestaDto;

import java.util.List;

public interface IContactanosServices {

//    CRUD
    List<ContactanosDtos> FindAllS();
    ContactanosDtos FindByIdS(Long Id);
    ContactanosDtos SaveS(ContactanosDtos dtos);
    ContactanosDtos UpdateS(Long Id, ContactanosDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);


//    PAGINACION
    ContactanosRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa);


//    OTROS
//    TRAER TODO POR ATRIBUTO
//    List<ContactanosDtos> FindAllByEmpresasId(Long Id);
}
