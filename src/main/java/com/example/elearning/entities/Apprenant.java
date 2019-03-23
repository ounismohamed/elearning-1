package com.example.elearning.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@DiscriminatorValue("A")
public class Apprenant extends Profile {

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Apprenant_has_formation",
            joinColumns = { @JoinColumn(name = "idapprenant") },
            inverseJoinColumns = { @JoinColumn(name = "idformation") }
    )
    private Collection<Formation> formations;


    public Apprenant(String identifiant, String motdepasse, String nom, String email) {
        super(identifiant, motdepasse, nom, email);
    }
}
