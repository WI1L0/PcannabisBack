package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer> {

//    public Usuarios findBynombreYpassword(String nombreUsuarios, String passwordUsuarios);
//
//    public Boolean existsBynombreUsuarios(String nombreUsuarios);

}
