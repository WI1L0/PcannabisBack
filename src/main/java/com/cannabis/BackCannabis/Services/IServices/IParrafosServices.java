package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.FotosNoticiasDtos;
import com.cannabis.BackCannabis.Dtos.ParrafosDtos;
import com.cannabis.BackCannabis.Modelos.Parrafos;

import java.util.List;

public interface IParrafosServices {

//    CRUD
    List<ParrafosDtos> FindAllS();
    ParrafosDtos FindByIdS(Long Id);
    ParrafosDtos SaveS(ParrafosDtos dtos);
    ParrafosDtos UpdateS(Long Id, ParrafosDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);


//    OTROS

//    TRAER TODO POR ATRIBUTO
    List<ParrafosDtos> findByParrafosAll(Long Id);
}
