package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.UsosAplicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsosAplicacionesRepository extends JpaRepository<UsosAplicaciones, Integer> {
}
