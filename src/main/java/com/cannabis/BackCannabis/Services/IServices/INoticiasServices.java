package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.NoticiasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.NoticiasRespuestaDto;

import java.util.List;

public interface INoticiasServices {

//    CRUD
    NoticiasDtos FindByIdS(Long Id);
    NoticiasDtos SaveS(NoticiasDtos dtos, String nombreEmpresa);
    NoticiasDtos UpdateS(Long Id, NoticiasDtos dtos);

//    CRUD MODIFICADO
    NoticiasDtos LogicoDeleteS(Long Id);

//    PAGINACION
    NoticiasRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa);
    NoticiasRespuestaDto FindByTituloAndFecha(int numeroDePagina, int medidaDePagina, String estado, String nombreEmpresa, String tituloOrFecha);

//    ACTUALIZAR ESTADOS
    NoticiasDtos updateEstado(Long id);


}
