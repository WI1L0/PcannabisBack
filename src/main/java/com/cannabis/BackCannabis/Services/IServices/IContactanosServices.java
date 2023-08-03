package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.CategoriasProductosDtos;
import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.NoticiasDtos;
import com.cannabis.BackCannabis.Dtos.ReservasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.ContactanosRespuestaDto;
import com.cannabis.BackCannabis.Dtos.Respuestas.NoticiasRespuestaDto;

import java.util.List;

public interface IContactanosServices {

//    CRUD
//    List<ContactanosDtos> FindAllS();
    ContactanosDtos FindByIdS(Long Id);
    ContactanosDtos SaveS(ContactanosDtos dtos, String nombreEmpresa);
    ContactanosDtos UpdateS(Long Id, ContactanosDtos dtos);
//    void DeleteS(Long Id);


//    CRUD MODIFICADO
    ContactanosDtos LogicoDeleteS(Long Id);


//    PAGINACION
    ContactanosRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa);
    ContactanosRespuestaDto FindByNombreOrEmail(int numeroDePagina, int medidaDePagina, String estado, String nombreEmpresa, String nombreOrEmail);

    //    ACTUALIZAR ESTADOS
    ContactanosDtos updateEstado(Long id);
    ContactanosDtos updateEstadoVistoOrNoVisto(Long id);

//    OTROS
//    TRAER TODO POR ATRIBUTO
//    List<ContactanosDtos> FindAllByEmpresasId(Long Id);
}
