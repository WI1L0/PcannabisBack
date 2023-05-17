package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresasRepository extends JpaRepository<Empresas, Integer> {
}
