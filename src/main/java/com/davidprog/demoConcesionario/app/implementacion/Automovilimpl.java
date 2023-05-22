package com.davidprog.demoConcesionario.app.implementacion;

import com.davidprog.demoConcesionario.app.entity.Automovil;
import com.davidprog.demoConcesionario.app.entity.Persona;
import com.davidprog.demoConcesionario.app.repositorio.RepositorioAutomovil;
import com.davidprog.demoConcesionario.app.servicio.AutomovilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Automovilimpl implements AutomovilServicio {

    @Autowired
    RepositorioAutomovil repositorioAutomovil;

    @Override
    public List<Automovil> encontrarTodos() {

        return this.repositorioAutomovil.findAll();
    }

    @Override
    public Automovil encontrarPorId(int id) {

        Automovil automovil = this.repositorioAutomovil.encontrarPorId(id);
        return automovil;
    }

    @Override
    public void actualizarAutomovil(Automovil automovil) {

        if (automovil.getId_automovil()!=0){
            this.repositorioAutomovil.save(automovil);
        }
    }

    @Override
    public void crearAutomovil(Automovil automovil) {

        this.repositorioAutomovil.save(automovil);
    }

    @Override
    public void elmiminarAutomovil(int id) {
        System.out.println("######"+id);
        Automovil automovil = this.repositorioAutomovil.getById(id);
        System.out.println("@@@@@@ "+automovil.toString());
        if (automovil != null){
            this.repositorioAutomovil.delete(automovil);
        }

    }
}
