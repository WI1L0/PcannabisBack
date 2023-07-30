package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.EmpresasDtos;
import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Repository.IEmpresasRepository;
import com.cannabis.BackCannabis.Services.IServices.IEmpresasServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresasServicesImpl implements IEmpresasServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IEmpresasRepository repository;


    @Override
    public List<EmpresasDtos> FindAllS() {
        List<EmpresasDtos> empresasDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> empresasDtosList.add(mapearDTO(data)));
        return empresasDtosList;
    }

    @Override
    public EmpresasDtos FindByIdS(Long Id) {
        Empresas empresas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Empresas", "Id", Id));
        return mapearDTO(empresas);
    }

    @Override
    public EmpresasDtos SaveS(EmpresasDtos dtos) {
        Empresas empresas = repository.save(mapearEntidad(dtos));
        return mapearDTO(empresas);
    }

    @Override
    public EmpresasDtos UpdateS(Long Id, EmpresasDtos dtos) {
        Empresas empresas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Empresas", "Id", Id));

        empresas.setCelularEmpresa(dtos.getCelularEmpresa());
        empresas.setUrlCelularEmpresa(dtos.getUrlCelularEmpresa());
        empresas.setDireccionEmpresa(dtos.getDireccionEmpresa());
        empresas.setUrlDireccionEmpresa(dtos.getUrlDireccionEmpresa());
        empresas.setTelefonoEmpresa(dtos.getTelefonoEmpresa());
        empresas.setUrlDireccionEmpresaGoogle(dtos.getUrlDireccionEmpresaGoogle());

        return mapearDTO(repository.save(empresas));
    }
//
//    @Override
//    public void DeleteS(Long Id) {
//        Empresas empresas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Empresas", "Id", Id));
//        repository.delete(empresas);
//    }

    @Override
    public void LogicoDeleteS(Long Id) {
        Empresas empresas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Empresas", "Id", Id));

        empresas.setEstEmpresa(!empresas.getEstEmpresa());

        repository.save(empresas);
    }


    @Override
    public EmpresasDtos findByNombreEmpresaActivo(String nombreEmpresa) {
        Empresas empresas = repository.findByNombreEmpresaAndEstEmpresaTrue(nombreEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionString("Empresas", "nombreEmpresa", nombreEmpresa));
        return mapearDTO(empresas);
    }


    //    METODOS REUTILIZABLES
    private Empresas mapearEntidad(EmpresasDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, Empresas.class);
    }

    private EmpresasDtos mapearDTO(Empresas entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, EmpresasDtos.class);
    }

}
