package edu.eci.arep.patrones.model.repository;

import edu.eci.arep.patrones.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,String> {
}
