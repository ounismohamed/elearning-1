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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Apprenant_has_module",
            joinColumns = { @JoinColumn(name = "idapprenant") },
            inverseJoinColumns = { @JoinColumn(name = "idmodule") }
    )
    private Collection<Module> modules;


    public Apprenant(String identifiant, String motdepasse, String nom, String email) {
        super(identifiant, motdepasse, nom, email);
    }
}
