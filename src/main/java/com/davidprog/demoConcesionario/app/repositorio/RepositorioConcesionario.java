package com.davidprog.demoConcesionario.app.repositorio;

import com.davidprog.demoConcesionario.app.entity.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioConcesionario extends JpaRepository<Concesionario, Integer> {

    @Query(value = "SELECT c FROM Concesionario c WHERE c.id_concesionario=id")
    public Concesionario encontrarPorId(int id);
}
