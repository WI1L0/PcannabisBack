package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.CaracteristicasProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICaracteristicasProductosRepository extends JpaRepository<CaracteristicasProductos, Integer>  {
}
