package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Personas;
import com.cannabis.BackCannabis.Modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonasRepository extends JpaRepository<Personas, Long> {

//    public Boolean existsByCedula(String cedula);
//    Optional<Usuarios> findByCorreo(String correo);
//    Boolean existsByCorreo(String correo);

}
