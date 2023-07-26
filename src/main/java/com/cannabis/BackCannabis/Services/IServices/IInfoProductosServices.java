package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.InfoProductosDtos;
import com.cannabis.BackCannabis.Modelos.InfoProductos;

import java.util.List;

public interface IInfoProductosServices {

//    CRUD
    List<InfoProductosDtos> FindAllS();
    InfoProductosDtos FindByIdS(Long Id);
    InfoProductosDtos SaveS(InfoProductosDtos dtos);
    InfoProductosDtos UpdateS(Long Id, InfoProductosDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);

}
