package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresasRepository extends JpaRepository<Empresas, Integer> {

    @Query(value="SELECT * FROM empresas e WHERE e.nombre_emp = :nombreEmp", nativeQuery = true)
    public Empresas findByNameEmpresas(@Param("nombreEmp") String nombreEmp);

//    @Query(value="SELECT e FROM empresas e WHERE e.nombreEmp = nombreEmp, nativeQuery = true)
//    Empresas findByNameEmpresas(String nombreEmp);

}
