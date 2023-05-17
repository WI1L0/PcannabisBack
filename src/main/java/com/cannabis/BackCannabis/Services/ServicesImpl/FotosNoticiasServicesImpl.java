package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.FotosNoticias;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.IFotosNoticiasRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.IFotosNoticiasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FotosNoticiasServicesImpl extends GenericServicesImpl<FotosNoticias, Integer> implements IFotosNoticiasServices {

    @Autowired
    IFotosNoticiasRepository iRepository;

    @Override
    public CrudRepository<FotosNoticias, Integer> getDao() {
        return iRepository;
    }
}
