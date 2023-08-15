package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.FotosNoticiasDtos;
import com.cannabis.BackCannabis.Dtos.ParrafosDtos;
import com.cannabis.BackCannabis.Modelos.FotosNoticias;
import com.cannabis.BackCannabis.Modelos.Noticias;
import com.cannabis.BackCannabis.Modelos.Parrafos;
import com.cannabis.BackCannabis.Repository.IFotosNoticiasRepository;
import com.cannabis.BackCannabis.Repository.INoticiasRepository;
import com.cannabis.BackCannabis.Services.IServices.IFotosNoticiasServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FotosNoticiasServicesImpl implements IFotosNoticiasServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IFotosNoticiasRepository repository;

    @Autowired
    private INoticiasRepository noticiasRepository;


    @Override
    public List<FotosNoticiasDtos> FindAllS() {
        List<FotosNoticiasDtos> fotosNoticiasDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> fotosNoticiasDtosList.add(mapearDTO(data)));
        return fotosNoticiasDtosList;
    }

    @Override
    public FotosNoticiasDtos FindByIdS(Long Id) {
        FotosNoticias fotosNoticias = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosNoticias", "Id", Id));
        return mapearDTO(fotosNoticias);
    }

    @Override
    public FotosNoticiasDtos SaveS(FotosNoticiasDtos dtos, Long IDNoticia) {
//        FotosNoticias fotosNoticias = repository.save(mapearEntidad(dtos));
//        return mapearDTO(fotosNoticias);
        Noticias noticia = noticiasRepository.findById(IDNoticia).orElseThrow(() -> new ResourceNotFoundExeptionLong("Noticias-save-empresa", "Id", IDNoticia));;
        FotosNoticias fotosNoticias = mapearEntidad(dtos);
        fotosNoticias.setEstFotosNoticia(true);
        fotosNoticias.setNoticiasRFN(noticia);
        return mapearDTO(repository.save(fotosNoticias));
    }

    @Override
    public FotosNoticiasDtos UpdateS(Long Id, FotosNoticiasDtos dtos) {
        FotosNoticias fotosNoticias = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosNoticias", "Id", Id));

        fotosNoticias.setFotosNoticia(dtos.getFotosNoticia());
        fotosNoticias.setEstFotosNoticia(dtos.getEstFotosNoticia());

        return mapearDTO(repository.save(fotosNoticias));
    }

    @Override
    public void DeleteS(Long Id) {
        FotosNoticias fotosNoticias = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosNoticias", "Id", Id));
        repository.delete(fotosNoticias);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        FotosNoticias fotosNoticias = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosNoticias", "Id", Id));

        fotosNoticias.setEstFotosNoticia(!fotosNoticias.getEstFotosNoticia());

        repository.save(fotosNoticias);
    }


    @Override
    public List<FotosNoticiasDtos> FindAllSActivo() {
        List<FotosNoticiasDtos> fotosNoticiasDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> fotosNoticiasDtosList.add(mapearDTO(data)));
        return fotosNoticiasDtosList;
    }

    @Override
    public List<FotosNoticiasDtos> FindAllByNoticiasId(Long Id) {
        Noticias noticias = noticiasRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Fotos-Noticias-Id", "Id", Id));
        List<FotosNoticiasDtos> fotosNoticiasDtosList = new ArrayList<>();
        repository.findByEstFotosNoticiaTrueAndNoticiasRFN(noticias).forEach(data -> fotosNoticiasDtosList.add(mapearDTO(data)));
//        List<Parrafos> parrafosDtosListAll = new ArrayList<>();
//        List<ParrafosDtos> parrafosDtosList = new ArrayList<>();

//        List<ParrafosDtos> parrafosDtosList = repository.findByNoticiasRPAndEstParrafoTrue(noticias).stream().map(parrafos -> mapearDTO(parrafos)).collect(Collectors.toList());
//        repository.findByNoticiasRPAndEstParrafoTrue(noticias).forEach(data -> parrafosDtosListAll.add(mapearDTO(data)));
//        parrafosDtosList = parrafosDtosListAll;
        return fotosNoticiasDtosList;
//
//        List<FotosNoticiasDtos> fotosNoticiasDtosListAll = new ArrayList<>();
//        List<FotosNoticiasDtos> fotosNoticiasDtosList = new ArrayList<>();
//
//        Noticias noticias = noticiasRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("FotosNoticias - Noticias", "Id", Id));
//        repository.findByNoticiasRFN(noticias).forEach(data -> fotosNoticiasDtosListAll.add(mapearDTO(data)));
//
//        if (estado.equals("all")) {
//            fotosNoticiasDtosList = fotosNoticiasDtosListAll;
//        } else {
//            for (int a = 0 ; a < fotosNoticiasDtosListAll.size() ; a++){
//                if (estado.equalsIgnoreCase("activo") && fotosNoticiasDtosListAll.get(a).getEstFotosNoticia() == true){
//                    fotosNoticiasDtosList.add(fotosNoticiasDtosListAll.get(a));
//                }
//                if (estado.equalsIgnoreCase("desactivo") && fotosNoticiasDtosListAll.get(a).getEstFotosNoticia() == false){
//                    fotosNoticiasDtosList.add(fotosNoticiasDtosListAll.get(a));
//                }
//            }
//        }

//        return null;
    }


    //    METODOS REUTILIZABLES
    private FotosNoticias mapearEntidad(FotosNoticiasDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, FotosNoticias.class);
    }

    private FotosNoticiasDtos mapearDTO(FotosNoticias entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, FotosNoticiasDtos.class);
    }

}
