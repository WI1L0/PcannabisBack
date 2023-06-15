package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Repository.IEmpresasRepository;
import com.cannabis.BackCannabis.Services.GenericServicesImpl;
import com.cannabis.BackCannabis.Services.IServices.IEmpresasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresasServicesImpl extends GenericServicesImpl<Empresas, Integer> implements IEmpresasServices {

    @Autowired
    IEmpresasRepository iRepository;

    @Override
    public CrudRepository<Empresas, Integer> getDao()
    {
        return iRepository;
    }

//    @Override
//    public Empresas findByNameEmpresas(String nombreEmp) {
//        return iRepository.findByNameEmpresas(nombreEmp);
//    }

    @Override
    public Empresas findByNameEmpresas(String name) {
        return iRepository.findByNameEmpresas(name);
    }
}
