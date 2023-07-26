package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.FotosEmpresas;
import com.cannabis.BackCannabis.Modelos.Noticias;
import com.cannabis.BackCannabis.Modelos.Parrafos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IParrafosRepository  extends JpaRepository<Parrafos, Long> {

    List<Parrafos> findByNoticiasRP(Noticias noticias);
    List<Parrafos> findByNoticiasRPAndEstParrafoTrue(Noticias noticias);

}
