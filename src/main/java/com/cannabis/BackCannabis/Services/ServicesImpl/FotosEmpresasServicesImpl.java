package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.FotosEmpresasDtos;
import com.cannabis.BackCannabis.Modelos.FotosEmpresas;
import com.cannabis.BackCannabis.Repository.IFotosEmpresasRepository;
import com.cannabis.BackCannabis.Services.IServices.IFotosEmpresasServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FotosEmpresasServicesImpl implements IFotosEmpresasServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IFotosEmpresasRepository repository;


    @Override
    public List<FotosEmpresasDtos> FindAllS() {
        List<FotosEmpresasDtos> fotosEmpresasDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> fotosEmpresasDtosList.add(mapearDTO(data)));
        return fotosEmpresasDtosList;
    }

    @Override
    public FotosEmpresasDtos FindByIdS(Long Id) {
        FotosEmpresas fotosEmpresas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosEmpresas", "Id", Id));
        return mapearDTO(fotosEmpresas);
    }

    @Override
    public FotosEmpresasDtos SaveS(FotosEmpresasDtos dtos) {
        FotosEmpresas fotosEmpresas = repository.save(mapearEntidad(dtos));
        return mapearDTO(fotosEmpresas);
    }

    @Override
    public FotosEmpresasDtos UpdateS(Long Id, FotosEmpresasDtos dtos) {
        FotosEmpresas fotosEmpresas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosEmpresas", "Id", Id));

        fotosEmpresas.setCategoriaFotoEmpresa(dtos.getCategoriaFotoEmpresa());
        fotosEmpresas.setFotoEmpresa(dtos.getFotoEmpresa());
        fotosEmpresas.setEstFotoEmpresa(dtos.getEstFotoEmpresa());

        return mapearDTO(repository.save(fotosEmpresas));
    }

    @Override
    public void DeleteS(Long Id) {
        FotosEmpresas fotosEmpresas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosEmpresas", "Id", Id));
        repository.delete(fotosEmpresas);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        FotosEmpresas fotosEmpresas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosEmpresas", "Id", Id));

        fotosEmpresas.setEstFotoEmpresa(!fotosEmpresas.getEstFotoEmpresa());

        repository.save(fotosEmpresas);
    }




//    @Override
//    public List<FotosEmpresasDtos> FindAllByEmpresasId(Long Id) {
//        List<FotosEmpresasDtos> fotosEmpresasDtosList = new ArrayList<>();
//        repository.findByEmpresasRFE(Id).forEach(data -> fotosEmpresasDtosList.add(mapearDTO(data)));
//        return fotosEmpresasDtosList;
//    }

    @Override
    public List<FotosEmpresasDtos> FindAllByCategorias(String categoria) {
        List<FotosEmpresasDtos> fotosEmpresasDtosList = new ArrayList<>();
        repository.findByCategoriaFotoEmpresa(categoria).forEach(data -> fotosEmpresasDtosList.add(mapearDTO(data)));
        return fotosEmpresasDtosList;
    }


    //    METODOS REUTILIZABLES
    private FotosEmpresas mapearEntidad(FotosEmpresasDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, FotosEmpresas.class);
    }

    private FotosEmpresasDtos mapearDTO(FotosEmpresas entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, FotosEmpresasDtos.class);
    }

}
