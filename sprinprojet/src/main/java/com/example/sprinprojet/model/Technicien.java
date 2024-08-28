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
@Table(name = "Technicien")
public class Technicien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idTechnicien;
    public String nom;
    public String prenom;
    public String email;
    public String tele;
    public String adresse;
    public String datenaissance;
    public String password;
    public String genre;



    @OneToMany
    public List<Agent> agent;


    @ManyToOne
    public Ticket tickets;


    @OneToMany
    public List<Admin> admin;


}
