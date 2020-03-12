package edu.eci.arep.patrones.controller;

import edu.eci.arep.patrones.model.Persona;
import edu.eci.arep.patrones.service.FormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RestController {

    private FormService formService;

    public RestController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("/personas")
    public ResponseEntity<?> getPersonas(){
        try {
            return new ResponseEntity<>(formService.getPersonas(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("not exist any Persona", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/personas/{document}")
    public ResponseEntity<?> getPersona(@PathVariable String document){
        try {
            return new ResponseEntity<>(formService.getPersona(document), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("The Persona doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/personas")
    public ResponseEntity<?> postPersona(@Valid @RequestBody Persona persona) {
        try {
            formService.savePersona(persona);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("No fue posible crear la persona",HttpStatus.FORBIDDEN);
        }
    }

}