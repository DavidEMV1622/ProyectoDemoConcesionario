package com.davidprog.demoConcesionario.app.servicio;

import com.davidprog.demoConcesionario.app.entity.Venta;

import java.util.List;

public interface VentaServicio {

    public List<Venta> encontrarTodos();

    public Venta encontrarPorId(int id);

    public void crearVenta(Venta venta);

}
