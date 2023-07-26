package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findBynombreRol(String nombreRol);
    @Query(value="select r.nombre_rol from roles r inner join usuario_roles ur on ur.id_rolr = r.id_rol where ur.id_usuarior  = :id and r.est_rol = '1';", nativeQuery = true)
    public List<String> findByRolesByIdUsuario(@Param("id") Long id);

}
