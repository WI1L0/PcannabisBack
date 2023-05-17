package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.UsosAplicaciones;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.IUsosAplicacionesRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.IUsosAplicacionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsosAplicacionesServicesImpl extends GenericServicesImpl<UsosAplicaciones, Integer> implements IUsosAplicacionesServices {

    @Autowired
    IUsosAplicacionesRepository iRepository;

    @Override
    public CrudRepository<UsosAplicaciones, Integer> getDao() {
        return iRepository;
    }
}
