package com.example.elearning.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PROFILE",discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Profile implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    @GeneratedValue (strategy = GenerationType.AUTO)
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
}
