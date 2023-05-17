package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Roles;
import com.cannabis.BackCannabis.Repository.IRolesRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IRolesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RolesServicesImpl extends GenericServicesImpl<Roles, Integer> implements IRolesServices {

    @Autowired
    IRolesRepository iRepository;

    @Override
    public CrudRepository<Roles, Integer> getDao() {
        return iRepository;
    }
}
