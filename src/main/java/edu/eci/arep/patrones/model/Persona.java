package edu.eci.arep.patrones.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    @Id
    private String nDocumento;
    private String tDoc;
    private String name;
    private String email;
    private String phone;
}
