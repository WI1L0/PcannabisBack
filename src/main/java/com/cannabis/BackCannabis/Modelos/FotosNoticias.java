package com.cannabis.BackCannabis.Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "fotosNoticias")
public class FotosNoticias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFotosNoticia")
    private Long idFotosNoticia;

    @Column(name = "fotosNoticia")
    private String fotosNoticia;

    @Column(name = "estFotosNoticia")
    private Boolean estFotosNoticia;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNoticiasR", nullable = false)
    private Noticias noticiasRFN;

}
