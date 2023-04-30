package com.davidprog.demoConcesionario.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class VentaDTO {
    private int id_venta;

    private Date fecha_ventas;

    private int monto_ventas;
}
