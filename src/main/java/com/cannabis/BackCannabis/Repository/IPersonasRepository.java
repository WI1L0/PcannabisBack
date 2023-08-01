package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Noticias;
import com.cannabis.BackCannabis.Modelos.Personas;
import com.cannabis.BackCannabis.Modelos.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonasRepository extends JpaRepository<Personas, Long> {

//    public Boolean existsByCedula(String cedula);
//    Optional<Usuarios> findByCorreo(String correo);
//    Boolean existsByCorreo(String correo);

    //    Obtener ocultos y visibles de las noticias parte administrador
//    Page<Personas> findByEstPersonaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(Boolean estOcultoVisibleNoticia, String nombreEmpresa, Pageable pageable);

    //    Obtener todas las noticias que no tengan eliminado logico
//    Page<Noticias> findByEstNoticiaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(String nombreEmpresa, Pageable pageable);


    Boolean existsByCedulaAndEstPersonaTrue(String cedula);
    Boolean existsByCorreoAndEstPersonaTrue(String correo);

}
