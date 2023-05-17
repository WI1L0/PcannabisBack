package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.CategoriasProductos;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.ICategoriaProductosRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.ICategoriasProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriasProductosServicesImpl extends GenericServicesImpl<CategoriasProductos, Integer> implements ICategoriasProductosServices {

    @Autowired
    ICategoriaProductosRepository iRepository;

    @Override
    public CrudRepository<CategoriasProductos, Integer> getDao() {
        return iRepository;
    }
}
