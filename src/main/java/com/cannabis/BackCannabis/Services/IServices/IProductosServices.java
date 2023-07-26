package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.ProductosDtos;
import com.cannabis.BackCannabis.Dtos.ProductosRespuestaDto;
import com.cannabis.BackCannabis.Modelos.Productos;

import java.util.List;

public interface IProductosServices {

//    CRUD
    ProductosDtos FindByIdS(Long Id);
    ProductosDtos SaveS(ProductosDtos dtos);
    ProductosDtos UpdateS(Long Id, ProductosDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);


//    PAGINACION
    ProductosRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir);


//    OTROS

//    TRAER TODO POR ATRIBUTO
    List<ProductosDtos> FindAllByEmpresasId(Long Id);
}
