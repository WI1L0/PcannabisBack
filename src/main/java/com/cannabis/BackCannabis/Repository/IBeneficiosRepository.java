package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Beneficios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBeneficiosRepository extends JpaRepository<Beneficios, Integer> {
}
