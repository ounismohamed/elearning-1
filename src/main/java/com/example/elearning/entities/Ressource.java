package com.example.elearning.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ressource implements Serializable {
    @Id
    @GeneratedValue
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
