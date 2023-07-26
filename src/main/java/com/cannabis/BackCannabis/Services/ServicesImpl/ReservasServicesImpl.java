package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.ReservasDtos;
import com.cannabis.BackCannabis.Modelos.Reservas;
import com.cannabis.BackCannabis.Repository.IReservasRepository;
import com.cannabis.BackCannabis.Services.IServices.IReservasServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservasServicesImpl implements IReservasServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IReservasRepository repository;


    @Override
    public List<ReservasDtos> FindAllS() {
        List<ReservasDtos> reservasDtosList = new ArrayList<>();
        repository.findAll().forEach(data -> reservasDtosList.add(mapearDTO(data)));
        return reservasDtosList;
    }

    @Override
    public ReservasDtos FindByIdS(Long Id) {
        Reservas reservas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Reservas", "Id", Id));
        return mapearDTO(reservas);
    }

    @Override
    public ReservasDtos SaveS(ReservasDtos dtos) {
        Reservas reservas = repository.save(mapearEntidad(dtos));
        return mapearDTO(reservas);
    }

    @Override
    public ReservasDtos UpdateS(Long Id, ReservasDtos dtos) {
        Reservas reservas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Reservas", "Id", Id));

        reservas.setFechaReserva(dtos.getFechaReserva());
        reservas.setTotalReserva(dtos.getTotalReserva());
        reservas.setEstReserva(dtos.getEstReserva());

        return mapearDTO(repository.save(reservas));
    }

    @Override
    public void DeleteS(Long Id) {
        Reservas reservas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Reservas", "Id", Id));
        repository.delete(reservas);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        Reservas reservas = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Reservas", "Id", Id));

        reservas.setEstReserva(!reservas.getEstReserva());

        repository.save(reservas);
    }


    @Override
    public List<ReservasDtos> FindAllByUsuarioId(Long Id) {
        List<ReservasDtos> reservasDtosList = new ArrayList<>();
        repository.findByUsuariosRR(Id).forEach(data -> reservasDtosList.add(mapearDTO(data)));
        return reservasDtosList;
    }


    //    METODOS REUTILIZABLES
    private Reservas mapearEntidad(ReservasDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, Reservas.class);
    }

    private ReservasDtos mapearDTO(Reservas entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, ReservasDtos.class);
    }

}
