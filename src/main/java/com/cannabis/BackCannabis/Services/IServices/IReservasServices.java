package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.ReservasDtos;
import com.cannabis.BackCannabis.Modelos.Reservas;

import java.util.List;

public interface IReservasServices {

//    CRUD
    List<ReservasDtos> FindAllS();
    ReservasDtos FindByIdS(Long Id);
    ReservasDtos SaveS(ReservasDtos dtos);
    ReservasDtos UpdateS(Long Id, ReservasDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);


//    OTROS

//    TRAER TODO POR ATRIBUTO
    List<ReservasDtos> FindAllByUsuarioId(Long Id);
}

