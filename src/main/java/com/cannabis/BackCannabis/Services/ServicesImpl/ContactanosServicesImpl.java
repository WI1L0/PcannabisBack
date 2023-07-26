package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.ContactanosDtos;
import com.cannabis.BackCannabis.Dtos.PersonasDtos;
import com.cannabis.BackCannabis.Dtos.Respuestas.ContactanosRespuestaDto;
import com.cannabis.BackCannabis.Dtos.Respuestas.UsuariosRespuestaDto;
import com.cannabis.BackCannabis.Dtos.UsuariosDtos;
import com.cannabis.BackCannabis.Modelos.Contactanos;
import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Modelos.Personas;
import com.cannabis.BackCannabis.Modelos.Usuarios;
import com.cannabis.BackCannabis.Repository.IContactanosRepository;
import com.cannabis.BackCannabis.Repository.IEmpresasRepository;
import com.cannabis.BackCannabis.Services.IServices.IContactanosServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

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
    public List<ContactanosDtos> FindAllS() {
        List<ContactanosDtos> contactanosDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> contactanosDtosList.add(mapearDTO(data)));
        return contactanosDtosList;
    }

    @Override
    public ContactanosDtos FindByIdS(Long Id) {
        Contactanos contactanos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Contactanos", "Id", Id));
        return mapearDTO(contactanos);
    }

    @Override
    public ContactanosDtos SaveS(ContactanosDtos dtos) {
        Contactanos contactanos = repository.save(mapearEntidad(dtos));
        return mapearDTO(contactanos);
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

    @Override
    public void DeleteS(Long Id) {
        Contactanos contactanos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Contactanos", "Id", Id));
        repository.delete(contactanos);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        Contactanos contactanos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Contactanos", "Id", Id));

        contactanos.setEstContactanos(!contactanos.getEstContactanos());

        repository.save(contactanos);
    }


    @Override
    public ContactanosRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir, String estado, String nombreEmpresa) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

        Page<Contactanos> contactanos = repository.findAll(pageable);
        List<Contactanos> listaContactanosAll = contactanos.getContent();
        List<Contactanos> listaContactanos = new ArrayList<>();

        Empresas empresas = empresasRepository.findByNombreEmpresaAndEstEmpresaTrue(nombreEmpresa).orElseThrow(() -> new ResourceNotFoundExeptionString("Contactanos-Empresa", "id", nombreEmpresa));

        if (estado.equals("all")) {
            for (int a = 0 ; a < listaContactanosAll.size() ; a++){
                if (listaContactanosAll.get(a).getEmpresasRC().getIdEmpresa() == empresas.getIdEmpresa()){
                    listaContactanos.add(listaContactanosAll.get(a));
                }
            }
        } else {
            for (int a = 0 ; a < listaContactanosAll.size() ; a++){
                if (estado.equalsIgnoreCase("activo") && listaContactanosAll.get(a).getEstContactanos() == true && listaContactanosAll.get(a).getEmpresasRC().getIdEmpresa() == empresas.getIdEmpresa()){
                    listaContactanos.add(listaContactanosAll.get(a));
                }
                if (estado.equalsIgnoreCase("desactivo") && listaContactanosAll.get(a).getEstContactanos() == false && listaContactanosAll.get(a).getEmpresasRC().getIdEmpresa() == empresas.getIdEmpresa()){
                    listaContactanos.add(listaContactanosAll.get(a));
                }
            }
        }

        List<ContactanosDtos> contenidoContactanos = listaContactanos.stream().map(contact -> mapearDTO(contact)).collect(Collectors.toList());

//        solo para enviar los datos de paginacion
        Page<Contactanos> contactanosPage = new PageImpl<>(listaContactanos);

        ContactanosRespuestaDto contactanosRespuestaDto = new ContactanosRespuestaDto();
        contactanosRespuestaDto.setContenido(contenidoContactanos);
        contactanosRespuestaDto.setNumeroPagina(contactanosPage.getNumber());
        contactanosRespuestaDto.setMedidaPagina(contactanosPage.getSize());
        contactanosRespuestaDto.setTotalElementos(contactanosPage.getTotalElements());
        contactanosRespuestaDto.setTotalPagina(contactanosPage.getTotalPages());
        contactanosRespuestaDto.setUltima(contactanosPage.isLast());

        return contactanosRespuestaDto;
    }


//    @Override
//    public List<ContactanosDtos> FindAllByEmpresasId(Long Id) {
//        List<ContactanosDtos> contactanosDtosList = new ArrayList<>();
//        repository.findByEmpresasRC(Id).forEach(data -> contactanosDtosList.add(mapearDTO(data)));
//        return contactanosDtosList;
//    }


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
