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
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private String statut;
    private String dateCloture;


    @OneToMany
    private List<Agent> agent;


    //@OneToMany
   // private List<Technicien> technicien;


    @OneToOne
    private Reclamation reclamation;

}
