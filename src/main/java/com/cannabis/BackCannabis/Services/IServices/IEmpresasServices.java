package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.EmpresasDtos;
import com.cannabis.BackCannabis.Modelos.CategoriasProductos;
import com.cannabis.BackCannabis.Modelos.Empresas;

import java.util.List;
import java.util.Optional;

public interface IEmpresasServices {

//    CRUD
    List<EmpresasDtos> FindAllS();
    EmpresasDtos FindByIdS(Long Id);
    EmpresasDtos SaveS(EmpresasDtos dtos);
    EmpresasDtos UpdateS(Long Id, EmpresasDtos dtos);
//    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);


//    OTROS

//    BUSCAR POR NOMBRE DE EMPRESA
    EmpresasDtos findByNombreEmpresaActivo(String nombreEmpresa);

}
