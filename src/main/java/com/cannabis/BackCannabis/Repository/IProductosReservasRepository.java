package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.ProductoReservas;
import com.cannabis.BackCannabis.Modelos.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductosReservasRepository extends JpaRepository<ProductoReservas, Long> {

    public List<ProductoReservas> findByProductosRP(Long productosRP);
    public List<ProductoReservas> findByReservasRR(Long reservasRR);

}
