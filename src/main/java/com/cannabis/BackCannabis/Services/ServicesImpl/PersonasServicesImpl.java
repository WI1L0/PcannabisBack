package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.PersonasDtos;
import com.cannabis.BackCannabis.Modelos.Personas;
import com.cannabis.BackCannabis.Repository.IPersonasRepository;
import com.cannabis.BackCannabis.Services.IServices.IPersonasServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonasServicesImpl implements IPersonasServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IPersonasRepository repository;


    @Override
    public List<PersonasDtos> FindAllS() {
        List<PersonasDtos> personasDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> personasDtosList.add(mapearDTO(data)));
        return personasDtosList;
    }

    @Override
    public PersonasDtos FindByIdS(Long Id) {
        Personas personas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Personas", "Id", Id));
        return mapearDTO(personas);
    }

    @Override
    public PersonasDtos SaveS(PersonasDtos dtos) {
        Personas personas = repository.save(mapearEntidad(dtos));
        return mapearDTO(personas);
    }

    @Override
    public PersonasDtos UpdateS(Long Id, PersonasDtos dtos) {
        Personas personas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Personas", "Id", Id));

        personas.setApellido1(dtos.getApellido1());
        personas.setApellido2(dtos.getApellido2());
        personas.setBarrio(dtos.getBarrio());
        personas.setCelular(dtos.getCelular());
        personas.setCiudad(dtos.getCiudad());
        personas.setEstPersona(dtos.getEstPersona());
        personas.setFNacimiento(dtos.getFNacimiento());
        personas.setGenero(dtos.getGenero());
        personas.setNombre1(dtos.getNombre1());
        personas.setNombre2(dtos.getNombre2());
        personas.setCorreo(dtos.getCorreo());
        personas.setReferencia(dtos.getReferencia());

        return mapearDTO(repository.save(personas));
    }

    @Override
    public void DeleteS(Long Id) {
        Personas personas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Personas", "Id", Id));
        repository.delete(personas);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        Personas personas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Personas", "Id", Id));

        personas.setEstPersona(!personas.getEstPersona());

        repository.save(personas);
    }


    //    METODOS REUTILIZABLES
    private Personas mapearEntidad(PersonasDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, Personas.class);
    }

    private PersonasDtos mapearDTO(Personas entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, PersonasDtos.class);
    }

}
