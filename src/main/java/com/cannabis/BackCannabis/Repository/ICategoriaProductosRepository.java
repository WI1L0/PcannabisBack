package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.CategoriasProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaProductosRepository extends JpaRepository<CategoriasProductos, Integer> {
}
