package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.PersonasDtos;
import com.cannabis.BackCannabis.Modelos.Personas;
import com.cannabis.BackCannabis.Repository.IPersonasRepository;
import com.cannabis.BackCannabis.Services.IServices.IPersonasServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonasServicesImpl implements IPersonasServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IPersonasRepository repository;


//    @Override
//    public List<PersonasDtos> FindAllS() {
//        List<PersonasDtos> personasDtosList = new ArrayList<>();
//        repository.findAll().forEach(data -> personasDtosList.add(mapearDTO(data)));
//        return personasDtosList;
//    }

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

//    @Override
//    public void DeleteS(Long Id) {
//        Personas personas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Personas", "Id", Id));
//        repository.delete(personas);
//    }

    @Override
    public void LogicoDeleteS(Long Id) {
        Personas personas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Personas", "Id", Id));
        personas.setEstPersona(!personas.getEstPersona());
        repository.save(personas);
    }

    @Override
    public Boolean existsByCedula(String cedula) {
        return repository.existsByCedulaAndEstPersonaTrue(cedula);
    }

    @Override
    public Boolean existsByCorreo(String correo) {
        return repository.existsByCorreoAndEstPersonaTrue(correo);
    }

//    @Override
//    public PersonasRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa) {
//        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending() : Sort.by(ordenarPor).descending();
//        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);
//        Page<Personas> personas = null;
//
//        if (estado.equalsIgnoreCase("activo")) {
//            personas = repository.findByEstOcultoVisibleNoticiaAndEstNoticiaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(true, nombreEmpresa, pageable);
//        }
//        if (estado.equalsIgnoreCase("desactivo")) {
//            personas = repository.findByEstOcultoVisibleNoticiaAndEstNoticiaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(false, nombreEmpresa, pageable);
//        }
//        if (estado.equalsIgnoreCase("all")) {
//            personas = repository.findByEstNoticiaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(nombreEmpresa, pageable);
//        }
//
//        List<PersonasDtos> contenidoPersonas = personas.getContent().stream().map(persona -> mapearDTO(persona)).collect(Collectors.toList());
//
//        PersonasRespuestaDto personasRespuestaDto = new PersonasRespuestaDto();
//        personasRespuestaDto.setContenido(contenidoPersonas);
//        personasRespuestaDto.setNumeroPagina(personas.getNumber());
//        personasRespuestaDto.setMedidaPagina(personas.getSize());
//        personasRespuestaDto.setTotalElementos(personas.getTotalElements());
//        personasRespuestaDto.setTotalPagina(personas.getTotalPages() - 1);
//        personasRespuestaDto.setUltima(personas.isLast());
//
//        return personasRespuestaDto;
//    }


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
