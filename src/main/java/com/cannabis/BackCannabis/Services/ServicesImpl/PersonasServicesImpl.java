package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Personas;
import com.cannabis.BackCannabis.Repository.IPersonasRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IPersonasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonasServicesImpl extends GenericServicesImpl<Personas, Integer> implements IPersonasServices {

    @Autowired
    IPersonasRepository iRepository;

    @Override
    public CrudRepository<Personas, Integer> getDao() {
        return iRepository;
    }

//    @Override
//    public Boolean existsByCedula(String cedula) {
//        return iRepository.existsByCedula(cedula);
//    }
}
