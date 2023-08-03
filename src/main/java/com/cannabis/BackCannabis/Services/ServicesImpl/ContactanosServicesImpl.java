package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.NoticiasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.ContactanosRespuestaDto;
import com.cannabis.BackCannabis.Modelos.Contactanos;
import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Modelos.Noticias;
import com.cannabis.BackCannabis.Repository.IContactanosRepository;
import com.cannabis.BackCannabis.Repository.IEmpresasRepository;
import com.cannabis.BackCannabis.Services.IServices.IContactanosServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactanosServicesImpl implements IContactanosServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IContactanosRepository repository;

    @Autowired
    private IEmpresasRepository empresasRepository;

    @Override
    public ContactanosDtos FindByIdS(Long Id) {
        Contactanos contactanos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Contactanos", "Id", Id));
        return mapearDTO(contactanos);
    }

    @Override
    public ContactanosDtos SaveS(ContactanosDtos dtos, String nombreEmpresa) {
        Empresas empresas = empresasRepository.findByNombreEmpresaAndEstEmpresaTrue(nombreEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionString("Noticias-save-empresa", "Id", nombreEmpresa));;
        Contactanos contactanos = mapearEntidad(dtos);
        contactanos.setFechaContactanos(LocalDate.now());
        contactanos.setEstVisto(false);
        contactanos.setEstContactanos(true);
        contactanos.setEstOcultoVisibleContactanos(true);
        contactanos.setEmpresasRC(empresas);
        return mapearDTO(repository.save(contactanos));
    }

    @Override
    public ContactanosDtos UpdateS(Long Id, ContactanosDtos dtos) {
        Contactanos contactanos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Contactanos", "Id", Id));

        contactanos.setNombreContactanos(dtos.getNombreContactanos());
        contactanos.setCelularContactanos(dtos.getCelularContactanos());
        contactanos.setEmailContactanos(dtos.getEmailContactanos());
        contactanos.setAsuntoContactanos(dtos.getAsuntoContactanos());
        contactanos.setDetalleContactanos(dtos.getDetalleContactanos());
        contactanos.setEstContactanos(dtos.getEstContactanos());

        return mapearDTO(repository.save(contactanos));
    }

//    @Override
//    public void DeleteS(Long Id) {
//        Contactanos contactanos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Contactanos", "Id", Id));
//        repository.delete(contactanos);
//    }

    @Override
    public ContactanosDtos LogicoDeleteS(Long Id) {
        Contactanos contactanos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Contactanos", "Id", Id));

        contactanos.setEstContactanos(!contactanos.getEstContactanos());

        return mapearDTO(repository.save(contactanos));
    }


    @Override
    public ContactanosRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);
        Page<Contactanos> contactanos = null;

        if (estado.equalsIgnoreCase("activo")) {
            contactanos = repository.findByEstOcultoVisibleContactanosAndEstContactanosTrueAndEmpresasRCNombreEmpresaAndEmpresasRCEstEmpresaTrue(true, nombreEmpresa, pageable);
        }
        if (estado.equalsIgnoreCase("desactivo")) {
            contactanos = repository.findByEstOcultoVisibleContactanosAndEstContactanosTrueAndEmpresasRCNombreEmpresaAndEmpresasRCEstEmpresaTrue(false, nombreEmpresa, pageable);
        }
        if (estado.equalsIgnoreCase("all")) {
            contactanos = repository.findByEstContactanosTrueAndEmpresasRCNombreEmpresaAndEmpresasRCEstEmpresaTrue(nombreEmpresa, pageable);
        }

        List<ContactanosDtos> contenidoContactanos = contactanos.stream().map(contact -> mapearDTO(contact)).collect(Collectors.toList());

        ContactanosRespuestaDto contactanosRespuestaDto = new ContactanosRespuestaDto();
        contactanosRespuestaDto.setContenido(contenidoContactanos);
        contactanosRespuestaDto.setNumeroPagina(contactanos.getNumber());
        contactanosRespuestaDto.setMedidaPagina(contactanos.getSize());
        contactanosRespuestaDto.setTotalElementos(contactanos.getTotalElements());
        contactanosRespuestaDto.setTotalPagina(contactanos.getTotalPages());
        contactanosRespuestaDto.setUltima(contactanos.isLast());

        return contactanosRespuestaDto;
    }

    @Override
    public ContactanosRespuestaDto FindByNombreOrEmail(int numeroDePagina, int medidaDePagina, String estado, String nombreEmpresa, String nombreOrEmail) {
        Empresas empresas = empresasRepository.findByNombreEmpresaAndEstEmpresaTrue(nombreEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionString("Noticias-Empresa", "id", nombreEmpresa));

        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);

        Page<Contactanos> contactanos = null;

        if (estado.equalsIgnoreCase("activo")) {
            contactanos = repository.buscarPorNombreOrEmailEstado(nombreOrEmail, empresas.getIdEmpresa(),  true, pageable);
        }
        if (estado.equalsIgnoreCase("desactivo")) {
            contactanos = repository.buscarPorNombreOrEmailEstado(nombreOrEmail, empresas.getIdEmpresa(),  false, pageable);
        }
        if (estado.equalsIgnoreCase("all")) {
            contactanos = repository.buscarPorNombreOrEmailAll(nombreOrEmail, empresas.getIdEmpresa(), pageable);
        }

        List<ContactanosDtos> contenidoContactanos = contactanos.stream().map(contact -> mapearDTO(contact)).collect(Collectors.toList());

        ContactanosRespuestaDto contactanosRespuestaDto = new ContactanosRespuestaDto();
        contactanosRespuestaDto.setContenido(contenidoContactanos);
        contactanosRespuestaDto.setNumeroPagina(contactanos.getNumber());
        contactanosRespuestaDto.setMedidaPagina(contactanos.getSize());
        contactanosRespuestaDto.setTotalElementos(contactanos.getTotalElements());
        contactanosRespuestaDto.setTotalPagina(contactanos.getTotalPages());
        contactanosRespuestaDto.setUltima(contactanos.isLast());

        return contactanosRespuestaDto;
    }


//    @Override
//    public List<ContactanosDtos> FindAllByEmpresasId(Long Id) {
//        List<ContactanosDtos> contactanosDtosList = new ArrayList<>();
//        repository.findByEmpresasRC(Id).forEach(data -> contactanosDtosList.add(mapearDTO(data)));
//        return contactanosDtosList;
//    }

    @Override
    public ContactanosDtos updateEstado(Long id) {
        Contactanos contactanos = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Contactanos-update-estado", "Id", id));

        if (contactanos.getEstOcultoVisibleContactanos() == false) {
            contactanos.setEstOcultoVisibleContactanos(true);
        } else {
            contactanos.setEstOcultoVisibleContactanos(false);
        }
        return mapearDTO(repository.save(contactanos));
    }

    @Override
    public ContactanosDtos updateEstadoVistoOrNoVisto(Long id) {
        Contactanos contactanos = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Contactanos-update-estado-visto", "Id", id));

        if (contactanos.getEstVisto() == false) {
            contactanos.setEstVisto(true);
        }
        return mapearDTO(repository.save(contactanos));
    }

    //    METODOS REUTILIZABLES
    private Contactanos mapearEntidad(ContactanosDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, Contactanos.class);
    }

    private ContactanosDtos mapearDTO(Contactanos entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, ContactanosDtos.class);
    }

}
