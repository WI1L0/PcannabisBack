package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Services.IGenericServices;

public interface IEmpresasServices extends IGenericServices<Empresas,Integer> {

    public Empresas findByNameEmpresas(String name);

}
