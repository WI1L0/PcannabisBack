package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.ProductosReservasDtos;
import com.cannabis.BackCannabis.Dtos.ReservasDtos;
import com.cannabis.BackCannabis.Modelos.ProductoReservas;

import java.util.List;

public interface IProductosReservasServices {

//    CRUD
    List<ProductosReservasDtos> FindAllS();
    ProductosReservasDtos FindByIdS(Long Id);
    ProductosReservasDtos SaveS(ProductosReservasDtos dtos);
    ProductosReservasDtos UpdateS(Long Id, ProductosReservasDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);


//    OTROS

//    TRAER TODO POR ATRIBUTO
    List<ProductosReservasDtos> FindAllByReservasId(Long Id);
    List<ProductosReservasDtos> FindAllByProductosId(Long Id);

}
