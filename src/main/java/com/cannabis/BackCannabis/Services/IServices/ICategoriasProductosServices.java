package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.CategoriasProductosDtos;
import com.cannabis.BackCannabis.Modelos.CategoriasProductos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ICategoriasProductosServices {

//    CRUD
    List<CategoriasProductosDtos> FindAllS();
    CategoriasProductosDtos FindByIdS(Long Id);
    CategoriasProductosDtos SaveS(CategoriasProductosDtos dtos);
    CategoriasProductosDtos UpdateS(Long Id, CategoriasProductosDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);

}
