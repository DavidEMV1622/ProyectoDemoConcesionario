package com.davidprog.demoConcesionario.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;


    @Temporal(TemporalType.TIMESTAMP) // Marcar la fecha y hora
    @Column(name = "fecha_venta")
    private Date fecha_ventas;

    @Column(name = "monto_venta")
    private int monto_ventas;

    @ManyToOne
    @JoinColumn(name = "fk_id_rol")
    Rol fk_id_rol;

    // creacion del objeto de muchas "Venta" para un "Automovil"
    @ManyToOne
    @JoinColumn(name = "fk_id_automovil")
    Automovil fk_id_automovil;

}
