package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.Noticias;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.IFotosNoticiasRepository;
import com.cannabis.BackCannabis.Repository.INoticiasRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.INoticiasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class NoticiasServicesImpl extends GenericServicesImpl<Noticias, Integer> implements INoticiasServices {

    @Autowired
    INoticiasRepository iRepository;

    @Override
    public CrudRepository<Noticias, Integer> getDao() {
        return iRepository;
    }
}
