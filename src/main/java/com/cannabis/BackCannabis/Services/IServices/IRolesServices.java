package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.RolesDtos;
import com.cannabis.BackCannabis.Modelos.Roles;

import java.util.List;

public interface IRolesServices {

//    CRUD
    List<RolesDtos> FindAllS();
    RolesDtos FindByIdS(Long Id);
    RolesDtos SaveS(RolesDtos dtos);
    RolesDtos UpdateS(Long Id, RolesDtos dtos);
    void DeleteS(Long Id);


    //    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);

}
