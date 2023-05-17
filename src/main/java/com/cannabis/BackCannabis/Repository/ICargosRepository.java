package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Cargos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICargosRepository extends JpaRepository<Cargos, Integer> {
}
