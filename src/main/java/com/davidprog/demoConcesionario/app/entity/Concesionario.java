package com.davidprog.demoConcesionario.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "concesionarios")
@Data
public class Concesionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_concesionario;

    @Column(name = "nombre")
    private String nombres;

    @Column(name = "direccion")
    private String direcciones;

    @Column(name = "correo")
    private String correos;

    @Column(name = "telefono")
    private int telefonos;


    @JsonIgnore
    @OneToMany(mappedBy = "fk_id_concesionario")
    private List<Automovil> automoviles;
}
