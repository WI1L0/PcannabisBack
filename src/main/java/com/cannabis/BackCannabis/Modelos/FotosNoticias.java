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
    @Column(name = "idFotosN")
    private Integer idFotosN;

    @Column(name = "fotosN")
    private String fotosN;

    @Column(name = "estFotosN")
    private Boolean estFotosN;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idNoticias",referencedColumnName ="idNoticias")
    private Noticias noticias;

}
