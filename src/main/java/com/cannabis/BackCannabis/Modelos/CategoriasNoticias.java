package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoriasNoticias")
public class CategoriasNoticias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriasN")
    private Integer idCategoriasN;

    @Column(name = "nombreCategoriasN")
    private String nombreCategoriasN;

    @Column(name = "estCategoriasN")
    private Boolean estCategoriasN;

    //RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "categoriaNoticias")
    private List<Noticias> noticias;

}
