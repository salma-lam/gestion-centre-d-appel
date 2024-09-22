package com.example.sprinprojet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reclamation ")
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamation;
    private String message;
    private String dateReclamation;
    private String typeReclamation;


 
 
  // Ajoutez la relation avec le client
  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;
 

/// Getters et setters
    public Long getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Long idReclamation) {
        this.idReclamation = idReclamation;
    }



    public void setDateReclamation(String dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public String getTypeReclamation() {
        return typeReclamation;
    }

    public void setTypeReclamation(String typeReclamation) {
        this.typeReclamation = typeReclamation;
    }


}

