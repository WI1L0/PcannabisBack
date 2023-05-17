package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuarios")
    private Integer idUsuarios;

    @Column(name = "nombreUsuarios")
    private String nombreUsuarios;

    @Column(name = "passwordUsuarios")
    private String passwordUsuarios;

    @Column(name = "fotoUsuarios")
    private String fotoUsuarios;

    @Column(name = "estUsuarios")
    private Boolean estUsuarios;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idPersonas",referencedColumnName ="idPersonas")
    private Personas personas;


    @OneToOne
    @JoinColumn(name = "idEmpleados")
    private Empleados empleados;

    @ManyToMany(mappedBy = "usuarios")
    private List<Roles> roles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuarios")
    private List<Reservas> reservas;
}
