package com.davidprog.demoConcesionario.app.servicio;

import com.davidprog.demoConcesionario.app.entity.Rol;

import java.util.List;

public interface RolServicio {

    public List<Rol> encontrarTodos();
    public Rol encontrarPorId(int id);

    public void actualizarRol(Rol rol);

    public void crearRol(Rol rol);

    public void eliminarRol(int id);

}
