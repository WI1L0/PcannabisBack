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
@Table(name = "usosAplicaciones")
public class UsosAplicaciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsosA")
    private Integer idUsosA;

    @Column(name = "tituloUsosA")
    private String tituloUsosA;

    @Column(name = "descripcionUsosA")
    private String descripcionUsosA;

    @Column(name = "fotoUsosA")
    private String fotoUsosA;

    @Column(name = "estUsosA")
    private Boolean estUsosA;


    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idEmpresas",referencedColumnName ="idEmpresas")
    private Empresas empresas;

}
