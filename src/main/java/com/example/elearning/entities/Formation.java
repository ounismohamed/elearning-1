package com.example.elearning.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Formation implements Serializable {
    @Id
    @GeneratedValue
    private int idformation;
    private String nomformation;
    private int duree;
    private String discipline;
    private String description;
    private int nombremodules;
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private Collection<Module> modules;

    @ManyToMany(mappedBy = "formations",fetch = FetchType.LAZY)
    private Collection<Apprenant> apprenants;

    public Formation(String nomformation, int duree, String discipline, String description, int nombremodules) {
        this.nomformation = nomformation;
        this.duree = duree;
        this.discipline = discipline;
        this.description = description;
        this.nombremodules = nombremodules;
    }

    public int getIdformation() {
        return idformation;
    }

    public void setIdformation(int idformation) {
        this.idformation = idformation;
    }

    public String getNomformation() {
        return nomformation;
    }

    public void setNomformation(String nomformation) {
        this.nomformation = nomformation;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombremodules() {
        return nombremodules;
    }

    public void setNombremodules(int nombremodules) {
        this.nombremodules = nombremodules;
    }

    public Collection<Module> getModules() {
        return modules;
    }

    public void setModules(Collection<Module> modules) {
        this.modules = modules;
    }

    public Collection<Apprenant> getApprenants() {
        return apprenants;
    }

    public void setApprenants(Collection<Apprenant> apprenants) {
        this.apprenants = apprenants;
    }
}
