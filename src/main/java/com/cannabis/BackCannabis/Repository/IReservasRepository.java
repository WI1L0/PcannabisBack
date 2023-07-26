package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservasRepository extends JpaRepository<Reservas, Long> {

    public List<Reservas> findByUsuariosRR(Long usuariosRR);

}
