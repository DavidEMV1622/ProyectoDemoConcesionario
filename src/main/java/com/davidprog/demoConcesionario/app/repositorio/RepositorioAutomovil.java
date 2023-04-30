package com.davidprog.demoConcesionario.app.repositorio;

import com.davidprog.demoConcesionario.app.entity.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAutomovil extends JpaRepository<Automovil, Integer> {

    @Query(value = "SELECT a FROM Automovil a WHERE a.id_automovil=id")
    public Automovil encontrarPorId(int id);
}
