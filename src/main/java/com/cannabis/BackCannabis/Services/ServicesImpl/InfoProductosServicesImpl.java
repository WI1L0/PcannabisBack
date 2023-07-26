package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.InfoProductosDtos;
import com.cannabis.BackCannabis.Modelos.InfoProductos;
import com.cannabis.BackCannabis.Repository.IInfoProductosRepository;
import com.cannabis.BackCannabis.Services.IServices.IInfoProductosServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoProductosServicesImpl implements IInfoProductosServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IInfoProductosRepository repository;


    @Override
    public List<InfoProductosDtos> FindAllS() {
        List<InfoProductosDtos> infoProductosDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> infoProductosDtosList.add(mapearDTO(data)));
        return infoProductosDtosList;
    }

    @Override
    public InfoProductosDtos FindByIdS(Long Id) {
        InfoProductos infoProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("InfoProductos", "Id", Id));
        return mapearDTO(infoProductos);
    }

    @Override
    public InfoProductosDtos SaveS(InfoProductosDtos dtos) {
        InfoProductos infoProductos = repository.save(mapearEntidad(dtos));
        return mapearDTO(infoProductos);
    }

    @Override
    public InfoProductosDtos UpdateS(Long Id, InfoProductosDtos dtos) {
        InfoProductos infoProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("InfoProductos", "Id", Id));

        infoProductos.setDescripcionInfProducto(dtos.getDescripcionInfProducto());
        infoProductos.setTituloInfProducto(dtos.getTituloInfProducto());
        infoProductos.setEstInfProducto(dtos.getEstInfProducto());

        return mapearDTO(repository.save(infoProductos));
    }

    @Override
    public void DeleteS(Long Id) {
        InfoProductos infoProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("InfoProductos", "Id", Id));
        repository.delete(infoProductos);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        InfoProductos infoProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("InfoProductos", "Id", Id));

        infoProductos.setEstInfProducto(!infoProductos.getEstInfProducto());

        repository.save(infoProductos);
    }


    //    METODOS REUTILIZABLES
    private InfoProductos mapearEntidad(InfoProductosDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, InfoProductos.class);
    }

    private InfoProductosDtos mapearDTO(InfoProductos entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, InfoProductosDtos.class);
    }

}
