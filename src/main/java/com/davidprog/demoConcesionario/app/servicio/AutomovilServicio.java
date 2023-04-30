package com.davidprog.demoConcesionario.app.servicio;

import com.davidprog.demoConcesionario.app.entity.Automovil;

import java.util.List;

public interface AutomovilServicio {

    public List<Automovil> encontrarTodos();
    public Automovil encontrarPorId(int id);

    public void actualizarAutomovil(Automovil automovil);

    public void crearAutomovil(Automovil automovil);

    public void elmiminarAutomovil(int id);
}
