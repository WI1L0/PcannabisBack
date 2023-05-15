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
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "passwordUsuario")
    private String passwordUsuario;

    @Column(name = "fotoUsuario")
    private String fotoUsuario;

    @Column(name = "estUsuario")
    private Boolean estUsuario;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Personas personas;


    @OneToOne
    @JoinColumn(name = "idEmpleado")
    private Empleados empleados;

    @ManyToMany(mappedBy = "usuarios")
    private List<Roles> roles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuarios")
    private List<Reserva> reservas;
}
