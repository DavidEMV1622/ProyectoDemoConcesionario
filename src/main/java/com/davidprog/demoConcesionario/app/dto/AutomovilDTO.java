package com.davidprog.demoConcesionario.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
@Component
public class AutomovilDTO {

    private int id_automovil;

    private String matriculas;

    private String marcas;

    private String modelos;

    private int anios;

    private String colores;

    private int kilometrajes;

    private int can_puertas;

    private String tipos_combustibles;

    private int cap_personas;

    private int precios;
}
