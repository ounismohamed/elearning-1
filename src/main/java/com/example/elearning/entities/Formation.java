package com.example.elearning.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
public class Formation implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idformation;
    @Column(nullable=false)
    private String nomformation;
    @Column(nullable=false)
    private int duree;
    private String discipline;
    private String description;
    private int nombremodules;
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Module> modules;

    @ManyToMany(mappedBy = "formations",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Apprenant> apprenants;
    @ManyToMany(mappedBy = "formations",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Formateur> formateurs;

    public Formation(String nomformation, int duree, String discipline, String description, int nombremodules) {
        this.nomformation = nomformation;
        this.duree = duree;
        this.discipline = discipline;
        this.description = description;
        this.nombremodules = nombremodules;
    }


}
