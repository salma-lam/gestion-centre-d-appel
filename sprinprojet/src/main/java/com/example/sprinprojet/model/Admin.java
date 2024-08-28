package com.example.sprinprojet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;
    private String nom;
    private String prenom;
    private String email;
    private String tele;
    private String adresse;
    private String datenaissance;
    private String password;
    private String genre;

    public Long getId() {
        return idAdmin;
    }

    // @ManyToOne
   // private Agent agent;


   // @ManyToOne
  //  private Message messages;


   // @ManyToOne
   // private Technicien techniciens;
}
