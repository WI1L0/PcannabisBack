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
    @Column(name = "idEmpleado")
    private Integer idEmpleado;

    @Column(name = "estEmpleado")
    private Boolean estEmpleado;

    //RELACIONES
    @OneToOne(mappedBy = "empleados")
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name="idCargo",referencedColumnName ="idCargo")
    private Cargos cargos;

    @ManyToOne
    @JoinColumn(name="idEmpresa",referencedColumnName ="idEmpresa")
    private Empresas empresas;

}
