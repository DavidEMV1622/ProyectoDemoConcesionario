package com.davidprog.demoConcesionario.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "automoviles")
@Data
public class Automovil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_automovil;

    @Column(name = "matricula")
    private String matriculas;

    @Column(name = "marca")
    private String marcas;

    @Column(name = "modelo")
    private String modelos;

    @Column(name = "anio")
    private int anios;

    @Column(name = "color")
    private String colores;

    @Column(name = "kilometraje")
    private int kilometrajes;

    @Column(name = "puertas")
    private int can_puertas;

    @Column(name = "tipo_combustible")
    private String tipos_combustibles;

    @Column(name = "cap_personas")
    private int cap_personas;

    @Column(name = "precio")
    private int precios;


    @JsonIgnore
    @OneToMany(mappedBy = "fk_id_automovil")
    private List<Venta> ventas;

    // creacion del objeto de muchas "Automovil" para un "Concesionario"
    @ManyToOne
    @JoinColumn(name = "fk_id_concesionario")
    Concesionario fk_id_concesionario;
}
