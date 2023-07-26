package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "noticias")
public class Noticias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNoticia")
    private Long idNoticia;

    @Column(name = "tituloNoticia")
    private String tituloNoticia;

    @Column(name = "preDescripcionNoticia")
    private String preDescripcionNoticia;

    @Column(name = "fechaNoticia")
    private LocalDate fechaNoticia;

    @Column(name = "ubicacionNoticia")
    private String ubicacionNoticia;

    @Column(name = "portadaNoticia")
    private String portadaNoticia;

    @Column(name = "estOcultoVisibleNoticia")
    private Boolean estOcultoVisibleNoticia;

    @Column(name = "estNoticia")
    private Boolean estNoticia;


    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresasR", nullable = false)
    private Empresas empresasRN;

    @JsonBackReference
    @OneToMany(mappedBy = "noticiasRFN", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FotosNoticias> fotosNoticiasSet = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "noticiasRP", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Parrafos> parrafosSet = new HashSet<>();

}
