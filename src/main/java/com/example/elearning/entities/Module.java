package com.example.elearning.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
/*@JsonFormat(shape=JsonFormat.Shape.ARRAY)*/
public class Module implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
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
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY, cascade = CascadeType.ALL) //FetchType.LAZY: lazy loading only on demand
    private List<Ressource> ressources;
    @OneToMany(mappedBy = "idchapitre",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Chapitre> chapitres;
    @ManyToMany(mappedBy = "modules",fetch = FetchType.LAZY)
    private List<Apprenant> apprenants;

    public Module(String nom, String description, int duree, int nbrchapitre, String typeressource, Formation formation, Formateur formateur) {
        this.nom = nom;
        this.description = description;
        this.duree = duree;
        this.nbrchapitre = nbrchapitre;
        this.typeressource = typeressource;
        this.formation = formation;
        this.formateur = formateur;
    }


}
