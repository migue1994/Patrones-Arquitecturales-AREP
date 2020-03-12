package edu.eci.arep.patrones.service.impl;

import edu.eci.arep.patrones.model.Persona;
import edu.eci.arep.patrones.model.repository.PersonaRepository;
import edu.eci.arep.patrones.service.FormService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormServiceImp implements FormService {

    private final PersonaRepository personaRepository;

    public FormServiceImp(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> getPersona(String document) {
        return personaRepository.findById(document);
    }

    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }
}
