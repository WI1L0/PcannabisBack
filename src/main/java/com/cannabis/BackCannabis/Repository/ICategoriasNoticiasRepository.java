package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.CategoriasNoticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriasNoticiasRepository extends JpaRepository<CategoriasNoticias, Integer> {
}
