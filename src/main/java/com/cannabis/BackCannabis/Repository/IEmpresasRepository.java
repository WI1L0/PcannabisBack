package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmpresasRepository extends JpaRepository<Empresas, Long> {

    Optional<Empresas> findByNombreEmpresaAndEstEmpresaTrue(String nombreEmpresa);

}
