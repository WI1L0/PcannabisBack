package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.RolesDtos;
import com.cannabis.BackCannabis.Modelos.Roles;
import com.cannabis.BackCannabis.Repository.IRolesRepository;
import com.cannabis.BackCannabis.Services.IServices.IRolesServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServicesImpl implements IRolesServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IRolesRepository repository;


    @Override
    public List<RolesDtos> FindAllS() {
        List<RolesDtos> rolesDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> rolesDtosList.add(mapearDTO(data)));
        return rolesDtosList;
    }

    @Override
    public RolesDtos FindByIdS(Long Id) {
        Roles roles = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Roles", "Id", Id));
        return mapearDTO(roles);
    }

    @Override
    public RolesDtos SaveS(RolesDtos dtos) {
        Roles roles = repository.save(mapearEntidad(dtos));
        return mapearDTO(roles);
    }

    @Override
    public RolesDtos UpdateS(Long Id, RolesDtos dtos) {
        Roles roles = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Roles", "Id", Id));

        roles.setNombreRol(dtos.getNombreRol());
        roles.setEstRol(dtos.getEstRol());

        return mapearDTO(repository.save(roles));
    }

    @Override
    public void DeleteS(Long Id) {
        Roles roles = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Roles", "Id", Id));
        repository.delete(roles);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        Roles roles = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Roles", "Id", Id));

        roles.setEstRol(!roles.getEstRol());

        repository.save(roles);
    }


    //    METODOS REUTILIZABLES
    private Roles mapearEntidad(RolesDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, Roles.class);
    }

    private RolesDtos mapearDTO(Roles entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, RolesDtos.class);
    }
}
