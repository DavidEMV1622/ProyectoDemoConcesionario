package com.davidprog.demoConcesionario.app.repositorio;

import com.davidprog.demoConcesionario.app.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Integer> {

    // "Query" consulta a la clase Persona (Java)
    // "p" un alias para la tabla "Persona"
    @Query(value = "SELECT p FROM Persona p WHERE p.id_persona=id")
    public Persona encontrarPorId(int id);


}
