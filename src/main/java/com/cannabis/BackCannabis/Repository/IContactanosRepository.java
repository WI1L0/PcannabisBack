package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Contactanos;
import com.cannabis.BackCannabis.Modelos.FotosEmpresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContactanosRepository extends JpaRepository<Contactanos, Long> {

//    List<Contactanos> findByEmpresasRC(Long empresasRC);

}
