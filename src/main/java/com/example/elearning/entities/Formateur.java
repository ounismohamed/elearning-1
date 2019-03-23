package com.example.elearning.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@DiscriminatorValue("F")
public class Formateur extends Profile {
    private int anciennete;
    private String domaineExpertise;
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private Collection<Ressource> ressources;
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private Collection<Module> modules;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Formateur_has_formation",
            joinColumns = { @JoinColumn(name = "idformateur") },
            inverseJoinColumns = { @JoinColumn(name = "idformation") }
    )
    private Collection<Formation> formations;

    public Formateur(String identifiant, String motdepasse, String nom, String email, int anciennete, String domaineExpertise) {
        super(identifiant, motdepasse, nom, email);
        this.anciennete = anciennete;
        this.domaineExpertise = domaineExpertise;
    }

    public int getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }

    public String getDomaineExpertise() {
        return domaineExpertise;
    }

    public void setDomaineExpertise(String domaineExpertise) {
        this.domaineExpertise = domaineExpertise;
    }

    public Collection<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(Collection<Ressource> ressources) {
        this.ressources = ressources;
    }

    public Collection<Module> getModules() {
        return modules;
    }

    public void setModules(Collection<Module> modules) {
        this.modules = modules;
    }
}
