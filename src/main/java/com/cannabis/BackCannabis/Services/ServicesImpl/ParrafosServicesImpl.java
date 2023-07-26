package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.ParrafosDtos;
import com.cannabis.BackCannabis.Modelos.Noticias;
import com.cannabis.BackCannabis.Modelos.Parrafos;
import com.cannabis.BackCannabis.Repository.INoticiasRepository;
import com.cannabis.BackCannabis.Repository.IParrafosRepository;
import com.cannabis.BackCannabis.Services.IServices.IParrafosServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public ParrafosDtos SaveS(ParrafosDtos dtos) {
        Parrafos parrafos = repository.save(mapearEntidad(dtos));
        return mapearDTO(parrafos);
    }

    @Override
    public ParrafosDtos UpdateS(Long Id, ParrafosDtos dtos) {
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
    public List<ParrafosDtos> FindAllByNoticiasId(Long Id, String estado) {
        List<ParrafosDtos> parrafosDtosListAll = new ArrayList<>();
        List<ParrafosDtos> parrafosDtosList = new ArrayList<>();
        Noticias noticias = noticiasRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Parrafos-Noticias-Id", "Id", Id));

        repository.findByNoticiasRP(noticias).forEach(data -> parrafosDtosListAll.add(mapearDTO(data)));

        if (estado.equals("all")) {
            parrafosDtosList = parrafosDtosListAll;
        } else {
            for (int a = 0 ; a < parrafosDtosListAll.size() ; a++){
                if (estado.equalsIgnoreCase("activo") && parrafosDtosListAll.get(a).getEstParrafo() == true){
                    parrafosDtosList.add(parrafosDtosListAll.get(a));
                }
                if (estado.equalsIgnoreCase("desactivo") && parrafosDtosListAll.get(a).getEstParrafo() == true){
                    parrafosDtosList.add(parrafosDtosListAll.get(a));
                }
            }
        }

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
