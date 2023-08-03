package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.FotosEmpresasDtos;
import com.cannabis.BackCannabis.Dtos.FotosNoticiasDtos;

import java.util.List;

public interface IFotosNoticiasServices {

//    CRUD
    List<FotosNoticiasDtos> FindAllS();
    FotosNoticiasDtos FindByIdS(Long Id);
    FotosNoticiasDtos SaveS(FotosNoticiasDtos dtos);
    FotosNoticiasDtos UpdateS(Long Id, FotosNoticiasDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    List<FotosNoticiasDtos> FindAllSActivo();
    void LogicoDeleteS(Long Id);


//    OTROS

//    TRAER TODO POR ATRIBUTO
    List<FotosNoticiasDtos> FindAllByNoticiasId(Long Id);

}
