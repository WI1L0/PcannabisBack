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

    @Column(name = "tituloBeneficio")
    private String tituloBeneficio;

    @Column(name = "descripcionBeneficio")
    private String descripcionBeneficio;

    @Column(name = "fotoBeneficio")
    private String fotoBeneficio;

    @Column(name = "estBeneficio")
    private Boolean estBeneficio;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idEmpresa",referencedColumnName ="idEmpresa")
    private Empresas empresas;

}
