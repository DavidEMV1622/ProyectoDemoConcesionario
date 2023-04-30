package com.davidprog.demoConcesionario.app.implementacion;

import com.davidprog.demoConcesionario.app.entity.Venta;
import com.davidprog.demoConcesionario.app.repositorio.RepositorioVenta;
import com.davidprog.demoConcesionario.app.servicio.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaImpl implements VentaServicio {

    @Autowired
    RepositorioVenta repositorioVenta;

    @Override
    public List<Venta> encontrarTodos() {

        return this.repositorioVenta.findAll();
    }

    @Override
    public Venta encontrarPorId(int id) {

        Venta venta = this.repositorioVenta.encontrarPorId(id);
        return venta;
    }

    @Override
    public void crearVenta(Venta venta) {

        this.repositorioVenta.save(venta);
    }
}
