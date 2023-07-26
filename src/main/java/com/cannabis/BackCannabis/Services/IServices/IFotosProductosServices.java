package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.FotosNoticiasDtos;
import com.cannabis.BackCannabis.Dtos.FotosProductosDtos;

import java.util.List;

public interface IFotosProductosServices {

//    CRUD
    List<FotosProductosDtos> FindAllS();
    FotosProductosDtos FindByIdS(Long Id);
    FotosProductosDtos SaveS(FotosProductosDtos dtos);
    FotosProductosDtos UpdateS(Long Id, FotosProductosDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);


//    OTROS

//    TRAER TODO POR ATRIBUTO
    List<FotosProductosDtos> FindAllByProductosId(Long Id);
}
