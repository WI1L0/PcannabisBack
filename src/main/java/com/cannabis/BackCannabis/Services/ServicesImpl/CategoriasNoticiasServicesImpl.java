package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import com.cannabis.BackCannabis.Modelos.CategoriasNoticias;
import com.cannabis.BackCannabis.Repository.IBeneficiosRepository;
import com.cannabis.BackCannabis.Repository.ICategoriasNoticiasRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IBeneficiosServices;
import com.cannabis.BackCannabis.Services.IServices.ICategoriasNoticiasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriasNoticiasServicesImpl extends GenericServicesImpl<CategoriasNoticias, Integer> implements ICategoriasNoticiasServices {

    @Autowired
    ICategoriasNoticiasRepository iRepository;

    @Override
    public CrudRepository<CategoriasNoticias, Integer> getDao() {
        return iRepository;
    }
}
