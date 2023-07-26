package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.FotosProductosDtos;
import com.cannabis.BackCannabis.Modelos.FotosProductos;
import com.cannabis.BackCannabis.Repository.IFotosProductosRepository;
import com.cannabis.BackCannabis.Services.IServices.IFotosProductosServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FotosProductosServicesImpl implements IFotosProductosServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IFotosProductosRepository repository;


    @Override
    public List<FotosProductosDtos> FindAllS() {
        List<FotosProductosDtos> fotosProductosDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> fotosProductosDtosList.add(mapearDTO(data)));
        return fotosProductosDtosList;
    }

    @Override
    public FotosProductosDtos FindByIdS(Long Id) {
        FotosProductos fotosProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosProductos", "Id", Id));
        return mapearDTO(fotosProductos);
    }

    @Override
    public FotosProductosDtos SaveS(FotosProductosDtos dtos) {
        FotosProductos fotosProductos = repository.save(mapearEntidad(dtos));
        return mapearDTO(fotosProductos);
    }

    @Override
    public FotosProductosDtos UpdateS(Long Id, FotosProductosDtos dtos) {
        FotosProductos fotosProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosProductos", "Id", Id));

        fotosProductos.setFotosProducto(dtos.getFotoProductos());
        fotosProductos.setEstFotosProducto(dtos.getEstFotoProductos());

        return mapearDTO(repository.save(fotosProductos));
    }

    @Override
    public void DeleteS(Long Id) {
        FotosProductos fotosProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosProductos", "Id", Id));
        repository.delete(fotosProductos);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        FotosProductos fotosProductos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosProductos", "Id", Id));

        fotosProductos.setEstFotosProducto(!fotosProductos.getEstFotosProducto());

        repository.save(fotosProductos);
    }


    @Override
    public List<FotosProductosDtos> FindAllByProductosId(Long Id) {
        List<FotosProductosDtos> fotosProductosDtosList = new ArrayList<>();
        repository.findByProductosRFP(Id).forEach(data -> fotosProductosDtosList.add(mapearDTO(data)));
        return fotosProductosDtosList;
    }


    //    METODOS REUTILIZABLES
    private FotosProductos mapearEntidad(FotosProductosDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, FotosProductos.class);
    }

    private FotosProductosDtos mapearDTO(FotosProductos entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, FotosProductosDtos.class);
    }

}
