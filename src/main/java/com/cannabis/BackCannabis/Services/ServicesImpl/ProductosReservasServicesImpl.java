package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.ProductosReservasDtos;
import com.cannabis.BackCannabis.Modelos.ProductoReservas;
import com.cannabis.BackCannabis.Repository.IProductosReservasRepository;
import com.cannabis.BackCannabis.Services.IServices.IProductosReservasServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosReservasServicesImpl implements IProductosReservasServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductosReservasRepository repository;


    @Override
    public List<ProductosReservasDtos> FindAllS() {
        List<ProductosReservasDtos> productosReservasDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> productosReservasDtosList.add(mapearDTO(data)));
        return productosReservasDtosList;
    }

    @Override
    public ProductosReservasDtos FindByIdS(Long Id) {
        ProductoReservas productoReservas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("ProductoReservas", "Id", Id));
        return mapearDTO(productoReservas);
    }

    @Override
    public ProductosReservasDtos SaveS(ProductosReservasDtos dtos) {
        ProductoReservas productoReservas = repository.save(mapearEntidad(dtos));
        return mapearDTO(productoReservas);
    }

    @Override
    public ProductosReservasDtos UpdateS(Long Id, ProductosReservasDtos dtos) {
        ProductoReservas productoReservas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("ProductoReservas", "Id", Id));

        productoReservas.setCantidadProductoReservas(dtos.getCantidadProductoReservas());
        productoReservas.setPrecioProductoReservas(dtos.getPrecioProductoReservas());
        productoReservas.setEstProductoReservas(dtos.getEstProductoReservas());

        return mapearDTO(repository.save(productoReservas));
    }

    @Override
    public void DeleteS(Long Id) {
        ProductoReservas productoReservas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("ProductoReservas", "Id", Id));
        repository.delete(productoReservas);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        ProductoReservas productoReservas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("ProductoReservas", "Id", Id));

        productoReservas.setEstProductoReservas(!productoReservas.getEstProductoReservas());

        repository.save(productoReservas);
    }


    @Override
    public List<ProductosReservasDtos> FindAllByProductosId(Long id) {
        List<ProductosReservasDtos> productosReservasDtosList = new ArrayList<>();
        repository.findByProductosRP(id).forEach(data -> productosReservasDtosList.add(mapearDTO(data)));
        return productosReservasDtosList;
    }

    @Override
    public List<ProductosReservasDtos> FindAllByReservasId(Long id) {
        List<ProductosReservasDtos> productosReservasDtosList = new ArrayList<>();
        repository.findByReservasRR(id).forEach(data -> productosReservasDtosList.add(mapearDTO(data)));
        return productosReservasDtosList;
    }


    //    METODOS REUTILIZABLES
    private ProductoReservas mapearEntidad(ProductosReservasDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, ProductoReservas.class);
    }

    private ProductosReservasDtos mapearDTO(ProductoReservas entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, ProductosReservasDtos.class);
    }

}
