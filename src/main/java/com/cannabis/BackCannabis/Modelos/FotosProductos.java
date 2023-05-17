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
@Table(name = "fotosProductos")
public class FotosProductos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFotosP")
    private Integer idFotosP;

    @Column(name = "fotosP")
    private String fotosP;

    @Column(name = "estFotosP")
    private Boolean estFotosP;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idProductos",referencedColumnName ="idProductos")
    private Productos productos;

}
