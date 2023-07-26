package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.FotosEmpresas;
import com.cannabis.BackCannabis.Modelos.Noticias;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoticiasRepository extends JpaRepository<Noticias, Long> {

//    Obtener ocultos y visibles de las noticias parte administrador
    Page<Noticias> findByEstOcultoVisibleNoticiaAndEstNoticiaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(Boolean estOcultoVisibleNoticia, String nombreEmpresa, Pageable pageable);

//    Obtener todas las noticias que no tengan eliminado logico
    Page<Noticias> findByEstNoticiaTrueAndEmpresasRNNombreEmpresaAndEmpresasRNEstEmpresaTrue(String nombreEmpresa, Pageable pageable);

//    Eliminado logico de noticia y parrafos
    @Modifying
    @Query(value = "UPDATE parrafos SET est_parrafo = false WHERE id_noticiasr = :idNoticia", nativeQuery = true)
    int EliminarParrafos(@Param("idNoticia") Long idNoticia);

//    Busqueda por titulo y fecha
    @Query(value = "SELECT * FROM noticias n WHERE (n.fecha_noticia LIKE %:FechaOrTitulo% OR n.titulo_noticia LIKE %:FechaOrTitulo%) AND n.est_noticia = true AND n.id_empresasr = :idEmpresa  AND n.est_oculto_visible_noticia = :estado", nativeQuery = true)
    Page<Noticias> buscarPorFechayTituloEstado(String FechaOrTitulo, Long idEmpresa, Boolean estado, Pageable pageable);
    @Query(value = "SELECT * FROM noticias n WHERE (n.fecha_noticia LIKE %:FechaOrTitulo% OR n.titulo_noticia LIKE %:FechaOrTitulo%) AND n.est_noticia = true AND n.id_empresasr = :idEmpresa", nativeQuery = true)
    Page<Noticias> buscarPorFechayTituloAll(String FechaOrTitulo, Long idEmpresa, Pageable pageable);
}
