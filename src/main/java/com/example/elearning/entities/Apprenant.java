package com.example.elearning.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
    @DiscriminatorValue("A")
public class Apprenant extends Profile {

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Apprenant_has_formation",
            joinColumns = { @JoinColumn(name = "idapprenant",referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name = "idformation",referencedColumnName = "idformation") }
    )
    private List<Formation> formations;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Apprenant_has_module",
            joinColumns = { @JoinColumn(name = "idapprenant",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "idmodule",referencedColumnName = "id") }
    )
    private List<Module> modules;


    public Apprenant(String identifiant, String motdepasse, String nom, String email) {
        super(identifiant, motdepasse, nom, email);
    }
}
