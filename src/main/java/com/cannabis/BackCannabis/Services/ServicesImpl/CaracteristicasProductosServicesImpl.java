package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.CaracteristicasProductos;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.ICaracteristicasProductosRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.ICaracteristicasProductosServices;
import com.cannabis.BackCannabis.Services.IServices.ICategoriasProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CaracteristicasProductosServicesImpl extends GenericServicesImpl<CaracteristicasProductos, Integer> implements ICaracteristicasProductosServices {

    @Autowired
    ICaracteristicasProductosRepository iRepository;

    @Override
    public CrudRepository<CaracteristicasProductos, Integer> getDao() {
        return iRepository;
    }
}
