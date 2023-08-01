package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Long idUsuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "passwordUsuario")
    private String passwordUsuario;

    @Column(name = "fotoUsuario")
    private String fotoUsuario;

    @Column(name = "bloqueadoUsuario")
    private Boolean bloqueadoUsuario;

    @Column(name = "estUsuario")
    private Boolean estUsuario;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersonaR", nullable = false)
    private Personas personasRU;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "idUsuarioR", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "idRolR", referencedColumnName = "idRol"))
    private Set<Roles> rolesSet = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresasR", nullable = false)
    private Empresas empresasRU;

    @JsonBackReference
    @OneToMany(mappedBy = "usuariosRR", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservas> reservasSet = new HashSet<>();

}
