package com.cannabis.BackCannabis.Repository;

import com.cannabis.BackCannabis.Modelos.FotosNoticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotosNoticiasRepository extends JpaRepository<FotosNoticias, Integer> {
}
