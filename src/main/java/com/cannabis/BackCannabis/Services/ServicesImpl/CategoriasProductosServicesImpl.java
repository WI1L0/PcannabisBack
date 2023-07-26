package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.CategoriasProductosDtos;
import com.cannabis.BackCannabis.Modelos.CategoriasProductos;
import com.cannabis.BackCannabis.Repository.ICategoriaProductosRepository;
import com.cannabis.BackCannabis.Services.IServices.ICategoriasProductosServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriasProductosServicesImpl implements ICategoriasProductosServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ICategoriaProductosRepository repository;


    @Override
    public List<CategoriasProductosDtos> FindAllS() {
        List<CategoriasProductosDtos> categoriasProductosDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> categoriasProductosDtosList.add(mapearDTO(data)));
        return categoriasProductosDtosList;
    }

    @Override
    public CategoriasProductosDtos FindByIdS(Long Id) {
        CategoriasProductos categoriasProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("CategoriasProductos", "Id", Id));
        return mapearDTO(categoriasProductos);
    }

    @Override
    public CategoriasProductosDtos SaveS(CategoriasProductosDtos dtos) {
        CategoriasProductos categoriasProductos = repository.save(mapearEntidad(dtos));
        return mapearDTO(categoriasProductos);
    }

    @Override
    public CategoriasProductosDtos UpdateS(Long Id, CategoriasProductosDtos dtos) {
        CategoriasProductos categoriasProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("CategoriasProductos", "Id", Id));

        categoriasProductos.setNombreCategoriasProducto(dtos.getNombreCategoriasProducto());
        categoriasProductos.setEstCategoriasProducto(dtos.getEstCategoriasProducto());

        return mapearDTO(repository.save(categoriasProductos));
    }

    @Override
    public void DeleteS(Long Id) {
        CategoriasProductos categoriasProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("CategoriasProductos", "Id", Id));
        repository.delete(categoriasProductos);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        CategoriasProductos categoriasProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("CategoriasProductos", "Id", Id));

        categoriasProductos.setEstCategoriasProducto(!categoriasProductos.getEstCategoriasProducto());

        repository.save(categoriasProductos);
    }


    //    METODOS REUTILIZABLES
    private CategoriasProductos mapearEntidad(CategoriasProductosDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, CategoriasProductos.class);
    }

    private CategoriasProductosDtos mapearDTO(CategoriasProductos entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, CategoriasProductosDtos.class);
    }

}
