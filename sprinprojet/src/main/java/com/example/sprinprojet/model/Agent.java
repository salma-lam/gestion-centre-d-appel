package com.example.sprinprojet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgent;
    private String nom;
    private String prenom;
    private String email;
    private String tele;
    private String adresse;
    private String datenaissance;
    private String password;
    private String genre;



    @OneToMany
    private List<Admin> admin;

    public Long getId() {
        return idAgent;
    }



}
