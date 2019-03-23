package com.example.elearning.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Module implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String description;
    private int duree;
    private int nbrchapitre;
    private String typeressource;
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private Collection<Ressource> ressources;
    @OneToMany(mappedBy = "idchapitre",fetch = FetchType.LAZY)
    private Collection<Chapitre> chapitres;
    @ManyToMany(mappedBy = "modules",fetch = FetchType.LAZY)
    private Collection<Apprenant> apprenants;

    public Module(String nom, String description, int duree, int nbrchapitre, String typeressource, Formation formation, Formateur formateur) {
        this.nom = nom;
        this.description = description;
        this.duree = duree;
        this.nbrchapitre = nbrchapitre;
        this.typeressource = typeressource;
        this.formation = formation;
        this.formateur = formateur;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNbrchapitre() {
        return nbrchapitre;
    }

    public void setNbrchapitre(int nbrchapitre) {
        this.nbrchapitre = nbrchapitre;
    }

    public String getTyperessource() {
        return typeressource;
    }

    public void setTyperessource(String typeressource) {
        this.typeressource = typeressource;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Collection<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(Collection<Ressource> ressources) {
        this.ressources = ressources;
    }

    public Collection<Chapitre> getChapitres() {
        return chapitres;
    }

    public void setChapitres(Collection<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }
}
