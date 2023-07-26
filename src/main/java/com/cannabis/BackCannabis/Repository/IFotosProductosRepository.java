package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Contactanos;
import com.cannabis.BackCannabis.Modelos.FotosProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFotosProductosRepository extends JpaRepository<FotosProductos, Long> {

    List<FotosProductos> findByProductosRFP(Long productosRFP);

}
