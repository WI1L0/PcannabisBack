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
@Table(name = "empleados")
public class Empleados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleados")
    private Integer idEmpleados;

    @Column(name = "estEmpleados")
    private Boolean estEmpleados;

    //RELACIONES
    @OneToOne(mappedBy = "empleados")
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name="idCargos",referencedColumnName ="idCargos")
    private Cargos cargos;

    @ManyToOne
    @JoinColumn(name="idEmpresas",referencedColumnName ="idEmpresas")
    private Empresas empresas;

}
