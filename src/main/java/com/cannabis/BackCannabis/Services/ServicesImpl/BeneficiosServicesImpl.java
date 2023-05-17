package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.Roles;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.IRolesRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.IRolesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BeneficiosServicesImpl extends GenericServicesImpl<Beneficios, Integer> implements IBeneficiosServices {

    @Autowired
    IBeneficiosRepository iRepository;

    @Override
    public CrudRepository<Beneficios, Integer> getDao() {
        return iRepository;
    }
}
