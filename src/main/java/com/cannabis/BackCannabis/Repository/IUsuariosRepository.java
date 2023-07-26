package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Personas;
import com.cannabis.BackCannabis.Modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByNombreUsuario(String nombreUsuario);
//    Boolean existsByNombreUsuario(String nombreUsuario);
//    List<Usuarios> findByEmpresasRU(Long empresasRU);
//    List<Usuarios> findByPersonasRU(Personas personas);

}
