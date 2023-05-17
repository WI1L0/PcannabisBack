package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductosRepository extends JpaRepository<Productos, Integer> {
}
