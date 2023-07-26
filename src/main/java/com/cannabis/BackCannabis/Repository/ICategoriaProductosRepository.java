package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.CategoriasProductos;
import com.cannabis.BackCannabis.Modelos.FotosProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoriaProductosRepository extends JpaRepository<CategoriasProductos, Long> {

}
