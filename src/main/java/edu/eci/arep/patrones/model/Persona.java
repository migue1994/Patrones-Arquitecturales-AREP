package edu.eci.arep.patrones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

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
