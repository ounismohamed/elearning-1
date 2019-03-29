package com.example.elearning.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@Entity
public class Chapitre implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idchapitre;
    private String titre;
    private String description;
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    public Chapitre(String titre, String description, Module module) {
        this.titre = titre;
        this.description = description;
        this.module = module;
    }
}
