package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.Productos;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.IProductosRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.IProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductosServicesImpl extends GenericServicesImpl<Productos, Integer> implements IProductosServices {

    @Autowired
    IProductosRepository iRepository;

    @Override
    public CrudRepository<Productos, Integer> getDao() {
        return iRepository;
    }
}
