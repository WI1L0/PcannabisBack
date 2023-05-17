package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Usuarios;
import com.cannabis.BackCannabis.Repository.IUsuariosRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IUsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServicesImpl extends GenericServicesImpl<Usuarios, Integer> implements IUsuariosServices {

    @Autowired
    IUsuariosRepository iRepository;

    @Override
    public CrudRepository<Usuarios, Integer> getDao() {
        return iRepository;
    }

//    @Override
//    public Usuarios findBynombreYpassword(String nombreUsuarios, String passwordUsuarios) {
//        return iRepository.findBynombreYpassword(nombreUsuarios, passwordUsuarios);
//    }
//
//    @Override
//    public Boolean existsBynombreUsuarios(String nombreUsuarios) {
//        return iRepository.existsBynombreUsuarios(nombreUsuarios);
//    }
}
