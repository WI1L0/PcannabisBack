package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.FotosProductos;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.IFotosProductosRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.IFotosProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FotosProductosServicesImpl extends GenericServicesImpl<FotosProductos, Integer> implements IFotosProductosServices {

    @Autowired
    IFotosProductosRepository iRepository;

    @Override
    public CrudRepository<FotosProductos, Integer> getDao() {
        return iRepository;
    }
}
