package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.NoticiasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.ContactanosRespuestaDto;
import com.cannabis.BackCannabis.Dtos.Respuestas.NoticiasRespuestaDto;
import com.cannabis.BackCannabis.Modelos.Contactanos;
import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Modelos.Noticias;
import com.cannabis.BackCannabis.Repository.IEmpresasRepository;
import com.cannabis.BackCannabis.Repository.INoticiasRepository;
import com.cannabis.BackCannabis.Services.IServices.INoticiasServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticiasServicesImpl implements INoticiasServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private INoticiasRepository repository;

    @Autowired
    private IEmpresasRepository empresasRepository;

    @Override
    public NoticiasDtos FindByIdS(Long Id) {
        Noticias noticias = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Noticias", "Id", Id));
        return mapearDTO(noticias);
    }

    @Override
    public NoticiasDtos SaveS(NoticiasDtos dtos, String nombreEmpresa) {
        Empresas empresas = empresasRepository.findByNombreEmpresaAndEstEmpresaTrue(nombreEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionString("Noticias-save-empresa", "Id", nombreEmpresa));;
        Noticias noticias = mapearEntidad(dtos);
        noticias.setEmpresasRN(empresas);
        return mapearDTO(repository.save(noticias));
    }

    @Override
    public NoticiasDtos UpdateS(Long Id, NoticiasDtos dtos) {
        Noticias noticias = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Noticias", "Id", Id));

        noticias.setFechaNoticia(dtos.getFechaNoticia());
        noticias.setPreDescripcionNoticia(dtos.getPreDescripcionNoticia());
        noticias.setTituloNoticia(dtos.getTituloNoticia());
        noticias.setUbicacionNoticia(dtos.getUbicacionNoticia());
        noticias.setPortadaNoticia(dtos.getPortadaNoticia());
        noticias.setEstOcultoVisibleNoticia(dtos.getEstOcultoVisibleNoticia());

        return mapearDTO(repository.save(noticias));
    }

    @Transactional
    @Override
    public NoticiasDtos LogicoDeleteS(Long id) {
        Noticias noticias = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Noticias", "Id", id));
        noticias.setEstNoticia(!noticias.getEstNoticia());
        if (repository.EliminarParrafos(noticias.getIdNoticia()) <= 0) {
            throw new ResourceNotFoundExeptionLong("Noticias - parrafos - delete", "Id", noticias.getIdNoticia());
        }
        return mapearDTO(repository.save(noticias));
    }

    @Override
    public NoticiasRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending() : Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);
        Page<Noticias> noticias = null;

        if (estado.equalsIgnoreCase("activo")) {
            noticias = repository.findByEstOcultoVisibleNoticiaAndEstNoticiaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(true, nombreEmpresa, pageable);
        }
        if (estado.equalsIgnoreCase("desactivo")) {
            noticias = repository.findByEstOcultoVisibleNoticiaAndEstNoticiaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(false, nombreEmpresa, pageable);
        }
        if (estado.equalsIgnoreCase("all")) {
            noticias = repository.findByEstNoticiaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(nombreEmpresa, pageable);
        }

        List<NoticiasDtos> contenidoNoticias = noticias.getContent().stream().map(noticia -> mapearDTO(noticia)).collect(Collectors.toList());

        NoticiasRespuestaDto noticiasRespuestaDto = new NoticiasRespuestaDto();
        noticiasRespuestaDto.setContenido(contenidoNoticias);
        noticiasRespuestaDto.setNumeroPagina(noticias.getNumber());
        noticiasRespuestaDto.setMedidaPagina(noticias.getSize());
        noticiasRespuestaDto.setTotalElementos(noticias.getTotalElements());
        noticiasRespuestaDto.setTotalPagina(noticias.getTotalPages() - 1);
        noticiasRespuestaDto.setUltima(noticias.isLast());

        return noticiasRespuestaDto;
    }

    @Override
    public NoticiasRespuestaDto FindByTituloAndFecha(int numeroDePagina, int medidaDePagina, String estado, String nombreEmpresa, String tituloOrFecha) {
        Empresas empresas = empresasRepository.findByNombreEmpresaAndEstEmpresaTrue(nombreEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionString("Noticias-Empresa", "id", nombreEmpresa));

        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);

        Page<Noticias> noticias = null;

        if (estado.equalsIgnoreCase("activo")) {
            noticias = repository.buscarPorFechayTituloEstado(tituloOrFecha, empresas.getIdEmpresa(), true, pageable);
        }
        if (estado.equalsIgnoreCase("desactivo")) {
            noticias = repository.buscarPorFechayTituloEstado(tituloOrFecha, empresas.getIdEmpresa(), false, pageable);
        }
        if (estado.equalsIgnoreCase("all")) {
            noticias = repository.buscarPorFechayTituloAll(tituloOrFecha, empresas.getIdEmpresa(), pageable);
        }

        List<NoticiasDtos> contenidoNoticias = noticias.getContent().stream().map(noticia -> mapearDTO(noticia)).collect(Collectors.toList());

        NoticiasRespuestaDto noticiasRespuestaDto = new NoticiasRespuestaDto();
        noticiasRespuestaDto.setContenido(contenidoNoticias);
        noticiasRespuestaDto.setNumeroPagina(noticias.getNumber());
        noticiasRespuestaDto.setMedidaPagina(noticias.getSize());
        noticiasRespuestaDto.setTotalElementos(noticias.getTotalElements());
        noticiasRespuestaDto.setTotalPagina(noticias.getTotalPages() - 1);
        noticiasRespuestaDto.setUltima(noticias.isLast());

        return noticiasRespuestaDto;
    }

    @Override
    public NoticiasDtos updateEstado(Long id) {
        Noticias noticias = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Noticias-update-estado", "Id", id));

        if (noticias.getEstOcultoVisibleNoticia() == false) {
            noticias.setEstOcultoVisibleNoticia(true);
        } else {
            noticias.setEstOcultoVisibleNoticia(false);
        }
        return mapearDTO(repository.save(noticias));
    }

    //    METODOS REUTILIZABLES
    private Noticias mapearEntidad(NoticiasDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, Noticias.class);
    }

    private NoticiasDtos mapearDTO(Noticias entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, NoticiasDtos.class);
    }

}
