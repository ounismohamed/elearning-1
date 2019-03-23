package com.example.elearning.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Chapitre implements Serializable {
    @Id
    @GeneratedValue
    private int idchapitre;
    private String titre;
    private String description;
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    public Chapitre(String titre, String description, Module module) {
        this.titre = titre;
        this.description = description;
        this.module = module;
    }
}
