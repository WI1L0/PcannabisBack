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
@Table(name = "beneficios")
public class Beneficios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBeneficios")
    private Integer idBeneficios;

    @Column(name = "tituloBeneficios")
    private String tituloBeneficios;

    @Column(name = "descripcionBeneficios")
    private String descripcionBeneficios;

    @Column(name = "fotoBeneficios")
    private String fotoBeneficios;

    @Column(name = "estBeneficios")
    private Boolean estBeneficios;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idEmpresas",referencedColumnName ="idEmpresas")
    private Empresas empresas;

}
