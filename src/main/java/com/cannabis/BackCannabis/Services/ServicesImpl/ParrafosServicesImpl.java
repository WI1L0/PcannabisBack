package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.NoticiasDtos;
import com.cannabis.BackCannabis.Dtos.ParrafosDtos;
import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Modelos.Noticias;
import com.cannabis.BackCannabis.Modelos.Parrafos;
import com.cannabis.BackCannabis.Repository.INoticiasRepository;
import com.cannabis.BackCannabis.Repository.IParrafosRepository;
import com.cannabis.BackCannabis.Services.IServices.IParrafosServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParrafosServicesImpl implements IParrafosServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IParrafosRepository repository;

    @Autowired
    private INoticiasRepository noticiasRepository;


    @Override
    public List<ParrafosDtos> FindAllS() {
        List<ParrafosDtos> parrafosDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> parrafosDtosList.add(mapearDTO(data)));
        return parrafosDtosList;
    }

    @Override
    public ParrafosDtos FindByIdS(Long Id) {
        Parrafos parrafos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Parrafos", "Id", Id));
        return mapearDTO(parrafos);
    }

    @Override
    public ParrafosDtos SaveS(ParrafosDtos dtos, Long IDNoticia) {
        Noticias noticia = noticiasRepository.findById(IDNoticia).orElseThrow(() -> new ResourceNotFoundExeptionLong("Noticias-save-empresa", "Id", IDNoticia));;
        Parrafos parrafos = mapearEntidad(dtos);
        parrafos.setEstParrafo(true);
        parrafos.setNoticiasRP(noticia);
        return mapearDTO(repository.save(parrafos));
    }

    @Override
    public ParrafosDtos UpdateS( Long Id,ParrafosDtos dtos) {
        Parrafos parrafos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Parrafos", "Id", Id));
        parrafos.setParrafo(dtos.getParrafo());
        parrafos.setEstParrafo(dtos.getEstParrafo());
        return mapearDTO(repository.save(parrafos));
    }



    @Override
    public void DeleteS(Long Id) {
        Parrafos parrafos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Parrafos", "Id", Id));
        repository.delete(parrafos);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        Parrafos parrafos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Parrafos", "Id", Id));

        parrafos.setEstParrafo(!parrafos.getEstParrafo());

        repository.save(parrafos);
    }


    @Override
    public List<ParrafosDtos> findByParrafosAll(Long Id) {
        Noticias noticias = noticiasRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Parrafos-Noticias-Id", "Id", Id));
        List<ParrafosDtos> parrafosDtosList = new ArrayList<>();
        repository.findByEstParrafoTrueAndNoticiasRP(noticias).forEach(data -> parrafosDtosList.add(mapearDTO(data)));
//        List<Parrafos> parrafosDtosListAll = new ArrayList<>();
//        List<ParrafosDtos> parrafosDtosList = new ArrayList<>();

//        List<ParrafosDtos> parrafosDtosList = repository.findByNoticiasRPAndEstParrafoTrue(noticias).stream().map(parrafos -> mapearDTO(parrafos)).collect(Collectors.toList());
//        repository.findByNoticiasRPAndEstParrafoTrue(noticias).forEach(data -> parrafosDtosListAll.add(mapearDTO(data)));
//        parrafosDtosList = parrafosDtosListAll;
        return parrafosDtosList;
    }


    //    METODOS REUTILIZABLES
    private Parrafos mapearEntidad(ParrafosDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, Parrafos.class);
    }

    private ParrafosDtos mapearDTO(Parrafos entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, ParrafosDtos.class);
    }

}
