package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.FotosProductos;
import com.cannabis.BackCannabis.Modelos.InfoProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInfoProductosRepository extends JpaRepository<InfoProductos, Long> {

//    List<InfoProductos> findByProductosRIP(Long productosRIP);

}
