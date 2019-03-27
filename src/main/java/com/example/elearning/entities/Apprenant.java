package com.example.elearning.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
@DiscriminatorValue("A")
public class Apprenant extends Profile {

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Apprenant_has_formation",
            joinColumns = { @JoinColumn(name = "idapprenant") },
            inverseJoinColumns = { @JoinColumn(name = "idformation") }
    )
    private List<Formation> formations;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Apprenant_has_module",
            joinColumns = { @JoinColumn(name = "idapprenant") },
            inverseJoinColumns = { @JoinColumn(name = "idmodule") }
    )
    private List<Module> modules;


    public Apprenant(String identifiant, String motdepasse, String nom, String email) {
        super(identifiant, motdepasse, nom, email);
    }
}
