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
public class CategoriaNoticias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaNoticias")
    private Integer idCategoriaNoticias;

    @Column(name = "nombreCategoriaNoticias")
    private String nombreCategoriaNoticias;

    @Column(name = "estCategoriaNoticias")
    private Boolean estCategoriaNoticias;

    //RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "categoriaNoticias")
    private List<Noticias> noticias;

}
