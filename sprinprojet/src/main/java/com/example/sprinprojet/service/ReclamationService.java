package com.example.sprinprojet.service;

import com.example.sprinprojet.Repository.ReclamationRepository;
// import com.example.sprinprojet.Repository.TicketRepository;
import com.example.sprinprojet.model.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    // @Autowired
    // private TicketRepository ticketRepository;


    // Consulter Ticket
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    // Consulter Reclamtion
    public List<Reclamation> getReclamationsByClientId(Long clientId) {
        return reclamationRepository.findByClientId(clientId);
    }
    
    public void deleteReclamationById(Long idReclamation) {
        reclamationRepository.deleteById(idReclamation);
    }

    // Ajouter Reclamation
    public Reclamation saveReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }
}
