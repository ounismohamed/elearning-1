package com.example.elearning.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="TYPE_PROFILE",discriminatorType = DiscriminatorType.STRING,length = 1)
public class Profile implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
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
