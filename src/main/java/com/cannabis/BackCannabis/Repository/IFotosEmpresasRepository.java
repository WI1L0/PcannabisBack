package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.FotosEmpresas;
import com.cannabis.BackCannabis.Modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFotosEmpresasRepository extends JpaRepository<FotosEmpresas, Long> {

//    List<FotosEmpresas> findByEmpresasRFE(Long empresasRFE);
    List<FotosEmpresas> findByCategoriaFotoEmpresa(String categoriaFotoEmpresa);

}
