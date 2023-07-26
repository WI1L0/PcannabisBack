package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.PersonasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.UsuariosRespuestaDto;
import com.cannabis.BackCannabis.Dtos.UsuariosDtos;
import com.cannabis.BackCannabis.Modelos.*;
import com.cannabis.BackCannabis.Repository.IEmpresasRepository;
import com.cannabis.BackCannabis.Repository.IPersonasRepository;
import com.cannabis.BackCannabis.Repository.IRolesRepository;
import com.cannabis.BackCannabis.Repository.IUsuariosRepository;
import com.cannabis.BackCannabis.Services.IServices.IUsuariosServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuariosServicesImpl implements IUsuariosServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUsuariosRepository repository;

    @Autowired
    private IEmpresasRepository empresasRepository;

    @Autowired
    private IRolesRepository rolesRepository;

    @Autowired
    private IPersonasRepository personasRepository;


    @Override
    public List<UsuariosDtos> FindAllS() {
        List<UsuariosDtos> usuariosDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> usuariosDtosList.add(mapearDTO(data)));
        return usuariosDtosList;
    }

    @Override
    public UsuariosDtos FindByIdS(Long Id) {
        Usuarios usuarios = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuarios", "Id", Id));
        return mapearDTO(usuarios);
    }

    @Override
    public UsuariosDtos SaveS(UsuariosDtos dtos, Long idPersona, String nombreRol, Long idEmpresa) {

        Usuarios usuarios = mapearEntidad(dtos);

        Personas personas = modelMapper.map(personasRepository.findById(idPersona).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuario-Persona", "id", idPersona)), Personas.class);
        usuarios.setPersonasRU(personas);

        Empresas empresas = modelMapper.map(empresasRepository.findById(idEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuario-Empresa", "id", idEmpresa)), Empresas.class);
        usuarios.setEmpresasRU(empresas);

        Roles roles = rolesRepository.findBynombreRol(nombreRol).orElseThrow(() -> new ResourceNotFoundExeptionString("Usuario-Roles", "name", nombreRol));;
        usuarios.setRolesSet(Collections.singleton(roles));

        return mapearDTO(repository.save(usuarios));
    }

    @Override
    public UsuariosDtos UpdateS(Long Id, UsuariosDtos dtos) {
        Usuarios usuarios = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuarios", "Id", Id));

        usuarios.setFotoUsuario(dtos.getFotoUsuario());
        usuarios.setNombreUsuario(dtos.getNombreUsuario());
        usuarios.setPasswordUsuario(dtos.getPasswordUsuario());
        usuarios.setEstUsuario(dtos.getEstUsuario());

        return mapearDTO(repository.save(usuarios));
    }

    @Override
    public void DeleteS(Long Id) {
        Usuarios usuarios = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuarios", "Id", Id));
        repository.delete(usuarios);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        Usuarios usuarios = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuarios", "Id", Id));

        usuarios.setEstUsuario(!usuarios.getEstUsuario());

        repository.save(usuarios);
    }


    @Override
    public UsuariosDtos SaveClienteS(UsuariosDtos dtos, Long idPersona, Long idEmpresa) {

        Usuarios usuarios = mapearEntidad(dtos);

        Personas personas = modelMapper.map(personasRepository.findById(idPersona).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuario-Persona", "id", idPersona)), Personas.class);
        usuarios.setPersonasRU(personas);

        Empresas empresas = modelMapper.map(empresasRepository.findById(idEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuario-Empresa", "id", idEmpresa)), Empresas.class);
        usuarios.setEmpresasRU(empresas);

        Roles roles = rolesRepository.findBynombreRol("ROLE_CLIENTE").orElseThrow(() -> new ResourceNotFoundExeptionString("Usuario-Roles", "name", "ROLE_CLIENTE"));;
        usuarios.setRolesSet(Collections.singleton(roles));

        return mapearDTO(repository.save(usuarios));
    }


    @Override
    public UsuariosRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

        Page<Usuarios> usuarios = repository.findAll(pageable);
        List<Usuarios> listaDeUsuariosAll = usuarios.getContent();
        List<Usuarios> listaDeUsuarios = new ArrayList<>();
        List<Personas> listaDePersonas = new ArrayList<>();

        Empresas empresas = empresasRepository.findByNombreEmpresaAndEstEmpresaTrue(nombreEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionString("Usuario-Persona-Empresa", "id", nombreEmpresa));

        if (estado.equals("all")) {
            for (int a = 0 ; a < listaDeUsuariosAll.size() ; a++){
                if (listaDeUsuariosAll.get(a).getEmpresasRU().getIdEmpresa() == empresas.getIdEmpresa()){
                    listaDeUsuarios.add(listaDeUsuariosAll.get(a));
                    listaDePersonas.add(listaDeUsuariosAll.get(a).getPersonasRU());
                }
            }
        } else {
            for (int a = 0 ; a < listaDeUsuariosAll.size() ; a++){
                if (estado.equalsIgnoreCase("activo") && listaDeUsuariosAll.get(a).getEstUsuario() == true && listaDeUsuariosAll.get(a).getEmpresasRU().getIdEmpresa() == empresas.getIdEmpresa()){
                    listaDeUsuarios.add(listaDeUsuariosAll.get(a));
                    listaDePersonas.add(listaDeUsuariosAll.get(a).getPersonasRU());
                }
                if (estado.equalsIgnoreCase("desactivo") && listaDeUsuariosAll.get(a).getEstUsuario() == false && listaDeUsuariosAll.get(a).getEmpresasRU().getIdEmpresa() == empresas.getIdEmpresa()){
                    listaDeUsuarios.add(listaDeUsuariosAll.get(a));
                    listaDePersonas.add(listaDeUsuariosAll.get(a).getPersonasRU());
                }
            }
        }

        List<UsuariosDtos> contenidoUsuarios = listaDeUsuarios.stream().map(usuario -> mapearDTO(usuario)).collect(Collectors.toList());
        List<PersonasDtos> contenidoPersonas = listaDePersonas.stream().map(persona -> modelMapper.map(persona, PersonasDtos.class)).collect(Collectors.toList());

//        solo para enviar los datos de paginacion
        Page<Usuarios> usuariosPage = new PageImpl<>(listaDeUsuarios);

        UsuariosRespuestaDto usuariosRespuestaDto = new UsuariosRespuestaDto();
        usuariosRespuestaDto.setContenidoUsuarios(contenidoUsuarios);
        usuariosRespuestaDto.setContenidoPersonas(contenidoPersonas);
        usuariosRespuestaDto.setNumeroPagina(usuariosPage.getNumber());
        usuariosRespuestaDto.setMedidaPagina(usuariosPage.getSize());
        usuariosRespuestaDto.setTotalElementos(usuariosPage.getTotalElements());
        usuariosRespuestaDto.setTotalPagina(usuariosPage.getTotalPages());
        usuariosRespuestaDto.setUltima(usuariosPage.isLast());

        return usuariosRespuestaDto;
    }


    //    METODOS REUTILIZABLES
    private Usuarios mapearEntidad(UsuariosDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, Usuarios.class);
    }

    private UsuariosDtos mapearDTO(Usuarios entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, UsuariosDtos.class);
    }

}
