package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.FotosProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotosProductosRepository extends JpaRepository<FotosProductos, Integer> {
}
