package com.cannabis.BackCannabis.Services.IServices;

import com.cannabis.BackCannabis.Dtos.PersonasDtos;
import com.cannabis.BackCannabis.Modelos.Personas;

import java.util.List;

public interface IPersonasServices {

//    CRUD
    List<PersonasDtos> FindAllS();
    PersonasDtos FindByIdS(Long Id);
    PersonasDtos SaveS(PersonasDtos dtos);
    PersonasDtos UpdateS(Long Id, PersonasDtos dtos);
    void DeleteS(Long Id);


//    CRUD MODIFICADO
    void LogicoDeleteS(Long Id);

}
