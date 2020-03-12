package edu.eci.arep.patrones.service;

import edu.eci.arep.patrones.model.Persona;

import java.util.List;
import java.util.Optional;

public interface FormService {
    List<Persona> getPersonas();

    Optional<Persona> getPersona(String documet);

    Persona savePersona(Persona persona);
}
