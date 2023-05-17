package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.Cargos;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.ICargosRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.ICargosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CargosServicesImpl extends GenericServicesImpl<Cargos, Integer> implements ICargosServices {

    @Autowired
    ICargosRepository iRepository;

    @Override
    public CrudRepository<Cargos, Integer> getDao() {
        return iRepository;
    }
}
