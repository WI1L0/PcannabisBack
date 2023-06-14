package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresasRepository extends JpaRepository<Empresas, Integer> {

//    @Query("SELECT e FROM empresas e WHERE e.nombreEmp = '' ")
//    Empresas findByNameEmpresas();

}
