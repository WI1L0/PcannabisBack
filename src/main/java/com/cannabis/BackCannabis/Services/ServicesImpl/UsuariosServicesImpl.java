package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.NoticiasDtos;
import com.cannabis.BackCannabis.Dtos.PersonasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.NoticiasRespuestaDto;
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
import org.springframework.transaction.annotation.Transactional;

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


//    @Override
//    public List<UsuariosDtos> FindAllS() {
//        List<UsuariosDtos> usuariosDtosList = new ArrayList<>();
//        repository.findAll().forEach(data -> usuariosDtosList.add(mapearDTO(data)));
//        return usuariosDtosList;
//    }

    @Override
    public UsuariosDtos FindByIdS(Long Id) {
        Usuarios usuarios = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuarios", "Id", Id));
        return mapearDTO(usuarios);
    }

    @Override
    public UsuariosDtos SaveS(UsuariosDtos dtos, Long idPersona, String nombreRol, String nombreEmpresa) {

        Usuarios usuarios = mapearEntidad(dtos);

        Personas personas = modelMapper.map(personasRepository.findById(idPersona).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuario-Persona", "id", idPersona)), Personas.class);
        usuarios.setPersonasRU(personas);

        Empresas empresas = modelMapper.map(empresasRepository.findByNombreEmpresaAndEstEmpresaTrue(nombreEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionString("Usuario-Empresa", "id", nombreEmpresa)), Empresas.class);
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

    @Transactional
    @Override
    public UsuariosDtos LogicoDeleteS(Long Id) {
        Usuarios usuarios = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuarios", "Id", Id));
        Personas personas = personasRepository.findById(usuarios.getPersonasRU().getIdPersona()).orElseThrow(() -> new ResourceNotFoundExeptionLong("Empresa-Usuarios", "Id", Id));
        List<Usuarios> usuariosList = repository.findByPersonasRUAndEstUsuarioTrue(personas);
        if (usuariosList.size() == 1){
            if (repository.EliminarPersona(usuarios.getPersonasRU().getIdPersona()) <= 0) {
                throw new ResourceNotFoundExeptionLong("Usuarios - Persona - delete", "Id", usuarios.getIdUsuario());
            } else {
                usuarios.setEstUsuario(!usuarios.getEstUsuario());
            }
        } else {
            usuarios.setEstUsuario(!usuarios.getEstUsuario());
        }

        return mapearDTO(repository.save(usuarios));
    }

    @Override
    public UsuariosDtos SaveClienteS(UsuariosDtos dtos, Long idPersona, String nombreEmpresa) {

        Usuarios usuarios = mapearEntidad(dtos);

        Personas personas = modelMapper.map(personasRepository.findById(idPersona).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuario-Persona", "id", idPersona)), Personas.class);
        usuarios.setPersonasRU(personas);

        Empresas empresas = modelMapper.map(empresasRepository.findByNombreEmpresaAndEstEmpresaTrue(nombreEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionString("Usuario-Empresa", "id", nombreEmpresa)), Empresas.class);
        usuarios.setEmpresasRU(empresas);

        Roles roles = rolesRepository.findBynombreRol("ROLE_CLIENTE").orElseThrow(() -> new ResourceNotFoundExeptionString("Usuario-Roles", "name", "ROLE_CLIENTE"));;
        usuarios.setRolesSet(Collections.singleton(roles));

        return mapearDTO(repository.save(usuarios));
    }


    @Override
    public UsuariosRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

        Page<Usuarios> usuarios = null;

        if (estado.equalsIgnoreCase("desbloqueado")) {
            usuarios = repository.findByEstUsuarioTrueAndBloqueadoUsuarioAndEmpresasRUNombreEmpresaAndEmpresasRUEstEmpresaTrue(false, nombreEmpresa, pageable);
        }
        if (estado.equalsIgnoreCase("bloqueado")) {
            usuarios = repository.findByEstUsuarioTrueAndBloqueadoUsuarioAndEmpresasRUNombreEmpresaAndEmpresasRUEstEmpresaTrue(true, nombreEmpresa, pageable);
        }
        if (estado.equalsIgnoreCase("all")) {
            usuarios = repository.findByEstUsuarioTrueAndEmpresasRUNombreEmpresaAndEmpresasRUEstEmpresaTrue(nombreEmpresa, pageable);
        }

        List<Usuarios> listaDeUsuarios = usuarios.getContent();

        List<UsuariosDtos> contenidoUsuarios = listaDeUsuarios.stream()
                .map(usuario -> {
                    UsuariosDtos usuarioDTO = mapearDTO(usuario);
                    PersonasDtos personaDTO = modelMapper.map(usuario.getPersonasRU(), PersonasDtos.class);
                    usuarioDTO.setPersonas(personaDTO);
                    return usuarioDTO;
                })
                .collect(Collectors.toList());

        UsuariosRespuestaDto usuariosRespuestaDto = new UsuariosRespuestaDto();
        usuariosRespuestaDto.setContenidoUsuarios(contenidoUsuarios);
        usuariosRespuestaDto.setNumeroPagina(usuarios.getNumber());
        usuariosRespuestaDto.setMedidaPagina(usuarios.getSize());
        usuariosRespuestaDto.setTotalElementos(usuarios.getTotalElements());
        usuariosRespuestaDto.setTotalPagina(usuarios.getTotalPages() - 1);
        usuariosRespuestaDto.setUltima(usuarios.isLast());

        return usuariosRespuestaDto;
    }

    @Override
    public UsuariosRespuestaDto FindByCedulaAndApellido1(int numeroDePagina, int medidaDePagina, String estado, String nombreEmpresa, String CedulaOrApellido1) {
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);

        Page<Usuarios> usuarios = null;

        if (estado.equalsIgnoreCase("desbloqueado")) {
            usuarios = repository.buscarPorCedulayApellidoBloqueadoOrDesbloqueado(false, CedulaOrApellido1, nombreEmpresa, pageable);
        }
        if (estado.equalsIgnoreCase("bloqueado")) {
            usuarios = repository.buscarPorCedulayApellidoBloqueadoOrDesbloqueado(true, CedulaOrApellido1, nombreEmpresa, pageable);
        }
        if (estado.equalsIgnoreCase("all")) {
            usuarios = repository.buscarPorCedulayApellidoAll(CedulaOrApellido1, nombreEmpresa, pageable);
        }
        List<Usuarios> listaDeUsuarios = usuarios.getContent();

        List<UsuariosDtos> contenidoUsuarios = listaDeUsuarios.stream()
                .map(usuario -> {
                    UsuariosDtos usuarioDTO = mapearDTO(usuario);
                    PersonasDtos personaDTO = modelMapper.map(usuario.getPersonasRU(), PersonasDtos.class);
                    usuarioDTO.setPersonas(personaDTO);
                    return usuarioDTO;
                })
                .collect(Collectors.toList());
        
        UsuariosRespuestaDto usuariosRespuestaDto = new UsuariosRespuestaDto();
        usuariosRespuestaDto.setContenidoUsuarios(contenidoUsuarios);
        usuariosRespuestaDto.setNumeroPagina(usuarios.getNumber());
        usuariosRespuestaDto.setMedidaPagina(usuarios.getSize());
        usuariosRespuestaDto.setTotalElementos(usuarios.getTotalElements());
        usuariosRespuestaDto.setTotalPagina(usuarios.getTotalPages() - 1);
        usuariosRespuestaDto.setUltima(usuarios.isLast());

        return usuariosRespuestaDto;
    }

    @Override
    public UsuariosDtos BloquearOrDesbloquearUsuarioS(Long Id) {
        Usuarios usuarios = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Usuarios", "Id", Id));
        usuarios.setBloqueadoUsuario(!usuarios.getBloqueadoUsuario());
        return mapearDTO(repository.save(usuarios));
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
