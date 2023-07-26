package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.FotosEmpresas;
import com.cannabis.BackCannabis.Modelos.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductosRepository extends JpaRepository<Productos, Long> {

    List<Productos> findByEmpresasRP(Long empresasRP);

}
