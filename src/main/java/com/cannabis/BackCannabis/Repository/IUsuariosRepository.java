package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Empresas;
import com.cannabis.BackCannabis.Modelos.Noticias;
import com.cannabis.BackCannabis.Modelos.Personas;
import com.cannabis.BackCannabis.Modelos.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Long> {

//    List<Usuarios> FindByEmpresasRUNombreEmpresaAndEmpresasRNEstEmpresaTrueAndEstUsuarioTrue(String nombreEmpresa);

    //    Obtener usuarios true parte administrador
    Page<Usuarios> findByEstUsuarioTrueAndEmpresasRUNombreEmpresaAndEmpresasRUEstEmpresaTrue(String nombreEmpresa, Pageable pageable);

    Optional<Usuarios> findByNombreUsuario(String nombreUsuario);
//    Boolean existsByNombreUsuario(String nombreUsuario);
    List<Usuarios> findByPersonasRUAndEstUsuarioTrue(Personas personasRU);
//    List<Usuarios> findByPersonasRU(Personas personas);

//    Eliminado logico de usuarios y personas
    @Modifying
    @Query(value = "UPDATE personas SET est_persona = false WHERE id_persona = :idPersona", nativeQuery = true)
    int EliminarPersona(@Param("idPersona") Long idPersona);

//    Busqueda por cedula y apellido1
    @Query(value = "SELECT * FROM usuarios u INNER JOIN personas p ON p.id_persona = u.id_personar INNER JOIN empresas e ON e.id_empresa = u.id_empresasr WHERE (p.cedula LIKE %:celulaOrapellido1% OR p.apellido1 LIKE %:celulaOrapellido1%) AND u.est_usuario = true AND e.nombre_empresa = :empresa  AND e.est_empresa = true", nativeQuery = true)
    Page<Usuarios> buscarPorCedulayApellido(String celulaOrapellido1, String empresa, Pageable pageable);


}
