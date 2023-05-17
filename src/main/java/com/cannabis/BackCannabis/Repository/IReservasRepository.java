package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservasRepository extends JpaRepository<Reservas, Integer> {
}
