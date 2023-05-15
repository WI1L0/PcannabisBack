package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "noticias")
public class Noticias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNoticias")
    private Integer idNoticias;

    @Column(name = "tituloNoticias")
    private String tituloNoticias;

    @Column(name = "descripcionNoticias")
    private String descripcionNoticias;

    @Column(name = "fechaNoticias")
    private LocalDate fechaNoticias;

    @Column(name = "estNoticias")
    private Boolean estNoticias;


    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idEmpresa",referencedColumnName ="idEmpresa")
    private Empresas empresas;

    @ManyToOne
    @JoinColumn(name="idCategoriaNoticias",referencedColumnName ="idCategoriaNoticias")
    private CategoriaNoticias categoriaNoticias;

    @JsonIgnore
    @OneToMany(mappedBy = "noticias")
    private List<FotosNoticias> fotosNoticias;

}
