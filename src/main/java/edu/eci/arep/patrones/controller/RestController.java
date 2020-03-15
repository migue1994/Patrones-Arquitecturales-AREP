package edu.eci.arep.patrones.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.eci.arep.patrones.model.Persona;
import edu.eci.arep.patrones.service.FormService;

@Controller
@RequestMapping(value = "/personas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class RestController {
    private final FormService formService;

    public RestController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("")
    public ResponseEntity<?> getPersonas(){
        try {
            return new ResponseEntity<>(formService.getPersonas(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("not exist any Persona", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{document}")
    public ResponseEntity<?> getPersona(@PathVariable String document){
        try {
            return new ResponseEntity<>(formService.getPersona(document), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("The Persona doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> postPersona(@Valid @RequestBody Persona persona) {
        try {
            formService.savePersona(persona);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("No fue posible crear la persona",HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> putPersona(@Valid @RequestBody Persona persona){

        try {
            formService.savePersona(persona);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("No fue posible actualizar la persona",HttpStatus.FORBIDDEN);
        }
    }

}