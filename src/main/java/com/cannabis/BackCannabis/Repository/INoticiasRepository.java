package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoticiasRepository extends JpaRepository<Noticias, Integer> {
}
