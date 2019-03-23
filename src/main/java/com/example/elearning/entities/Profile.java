package com.example.elearning.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PROFILE",discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Profile implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String identifiant;
    private String motdepasse;
    private String nom;
    private String email;

    public Profile(String identifiant, String motdepasse,String nom, String email) {
        this.identifiant = identifiant;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
