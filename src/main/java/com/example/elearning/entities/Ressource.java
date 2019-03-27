package com.example.elearning.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@Entity
public class Ressource implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String type;
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    public Ressource(String nom, String type, Formateur formateur, Module module) {
        this.nom = nom;
        this.type = type;
        this.formateur = formateur;
        this.module = module;
    }


}
