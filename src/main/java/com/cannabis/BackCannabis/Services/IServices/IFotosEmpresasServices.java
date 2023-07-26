package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.FotosEmpresasDtos;

import java.util.List;

public interface IFotosEmpresasServices {

//    CRUD
    List<FotosEmpresasDtos> FindAllS();
    FotosEmpresasDtos FindByIdS(Long Id);
    FotosEmpresasDtos SaveS(FotosEmpresasDtos dtos);
    FotosEmpresasDtos UpdateS(Long Id, FotosEmpresasDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);


//    OTROS

//    TRAER TODO POR ATRIBUTO
//    List<FotosEmpresasDtos> FindAllByEmpresasId(Long Id);
    List<FotosEmpresasDtos> FindAllByCategorias(String categoria);
}
