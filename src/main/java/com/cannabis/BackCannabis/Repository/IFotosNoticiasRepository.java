package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.FotosEmpresas;
import com.cannabis.BackCannabis.Modelos.FotosNoticias;
import com.cannabis.BackCannabis.Modelos.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFotosNoticiasRepository extends JpaRepository<FotosNoticias, Long> {

//    List<FotosNoticias> findByNoticiasRFN(Noticias noticias);

//    List<FotosNoticias> findByEstFotosNoticiaTrue();

}
