package com.davidprog.demoConcesionario.app.negocio;

import com.davidprog.demoConcesionario.app.dto.AutomovilDTO;
import com.davidprog.demoConcesionario.app.dto.VentaDTO;
import com.davidprog.demoConcesionario.app.entity.Venta;
import com.davidprog.demoConcesionario.app.implementacion.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VentaNegocio {

    @Autowired
    private VentaImpl ventaImpl;

    private List<VentaDTO> listDTOVentas;

    public List<VentaDTO> encontrarTodos() {
        listDTOVentas = new ArrayList<>();
        this.ventaImpl.encontrarTodos().forEach(venta->{
            VentaDTO ventaDTO = new VentaDTO();
            ventaDTO.setId_venta(venta.getId_venta());
            ventaDTO.setFecha_ventas(venta.getFecha_ventas());
            ventaDTO.setMonto_ventas(venta.getMonto_ventas());
            this.listDTOVentas.add(ventaDTO);
        });
        return this.listDTOVentas;
    }

    public String crearVenta(VentaDTO ventaDTO) {
        Venta venta = new Venta();
        try {
            venta.setFecha_ventas(ventaDTO.getFecha_ventas());
            venta.setMonto_ventas(ventaDTO.getMonto_ventas());
            this.ventaImpl.crearVenta(venta);
            return "Se guardo los datos correctamente";

        } catch (Exception e) {
            return "Fallo algo";
        }

    }
}
