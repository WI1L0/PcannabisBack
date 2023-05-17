package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonasRepository extends JpaRepository<Personas, Integer> {

    //public Boolean existsByCedula(String cedula);

}
