package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Contactanos;
import com.cannabis.BackCannabis.Modelos.Noticias;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactanosRepository extends JpaRepository<Contactanos, Long> {

//    List<Contactanos> findByEmpresasRC(Long empresasRC);

    //    Obtener ocultos y visibles de contactanos parte administrador
    Page<Contactanos> findByEstOcultoVisibleContactanosAndEstContactanosTrueAndEmpresasRCNombreEmpresaAndEmpresasRCEstEmpresaTrue(Boolean estOcultoVisibleContactanos, String nombreEmpresa, Pageable pageable);
    Page<Contactanos> findByEstContactanosTrueAndEmpresasRCNombreEmpresaAndEmpresasRCEstEmpresaTrue(String nombreEmpresa, Pageable pageable);

    //    Busqueda por titulo y fecha
    @Query(value = "SELECT * FROM contactanos c WHERE (c.nombre_contactanos LIKE %:NombreOrEmail% OR c.email_contactanos LIKE %:NombreOrEmail%) AND c.est_contactanos = true AND c.id_empresasr = :idEmpresa  AND n.est_oculto_visible_contactanos = :estado", nativeQuery = true)
    Page<Contactanos> buscarPorNombreOrEmailEstado(String NombreOrEmail, Long idEmpresa, Boolean estado, Pageable pageable);
    @Query(value = "SELECT * FROM contactanos c WHERE (c.nombre_contactanos LIKE %:NombreOrEmail% OR c.email_contactanos LIKE %:NombreOrEmail%) AND c.est_contactanos = true AND c.id_empresasr = :idEmpresa", nativeQuery = true)
    Page<Contactanos> buscarPorNombreOrEmailAll(String NombreOrEmail, Long idEmpresa, Pageable pageable);

}
