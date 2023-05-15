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
    @Column(name = "idFotoNoticias")
    private Integer idFotoNoticias;

    @Column(name = "fotoNoticias")
    private String fotoNoticias;

    @Column(name = "estFotoNoticias")
    private Boolean estFotoNoticias;

    //RELACIONES

    @ManyToOne
    @JoinColumn(name="idNoticias",referencedColumnName ="idNoticias")
    private Noticias noticias;

}
