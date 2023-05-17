package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadosRepository extends JpaRepository<Empleados, Integer> {
}
