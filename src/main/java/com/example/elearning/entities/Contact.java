package com.example.elearning.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@Entity
public class Contact implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long idmsg;
    private String nom;
    private String email;
    private String msg;

    public Contact(String nom, String email, String msg) {
        this.nom = nom;
        this.email = email;
        this.msg = msg;
    }
}


