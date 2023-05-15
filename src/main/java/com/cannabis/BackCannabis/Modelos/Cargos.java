package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cargos")
public class Cargos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCargo")
    private Integer idCargo;

    @Column(name = "nombreCargo")
    private String nombreCargo;

    @Column(name = "estCargo")
    private Boolean estCargo ;


    //RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "cargos")
    private List<Empleados> empleados;

}
