package com.example.elearning.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
@DiscriminatorValue("F")
public class Formateur extends Profile {
    private int anciennete;
    private String domaineExpertise;
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ressource> ressources;
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Module> modules;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Formateur_has_formation",
            joinColumns = { @JoinColumn(name = "idformateur") },
            inverseJoinColumns = { @JoinColumn(name = "idformation") }
    )
    private List<Formation> formations;

    public Formateur(String identifiant, String motdepasse, String nom, String email, int anciennete, String domaineExpertise) {
        super(identifiant, motdepasse, nom, email);
        this.anciennete = anciennete;
        this.domaineExpertise = domaineExpertise;
    }


}
