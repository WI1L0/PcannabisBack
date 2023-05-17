package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Integer> {
}
