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
@Table(name = "usosAplicacion")
public class UsosAplicaciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsosAplicaciones")
    private Integer idUsosAplicaciones;

    @Column(name = "tituloUsosAplicaciones")
    private String tituloUsosAplicaciones;

    @Column(name = "descripcionUsosAplicaciones")
    private String descripcionUsosAplicaciones;

    @Column(name = "fotoUsosAplicaciones")
    private String fotoUsosAplicaciones;

    @Column(name = "estUsosAplicaciones")
    private Boolean estUsosAplicaciones;


    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idEmpresa",referencedColumnName ="idEmpresa")
    private Empresas empresas;

}
