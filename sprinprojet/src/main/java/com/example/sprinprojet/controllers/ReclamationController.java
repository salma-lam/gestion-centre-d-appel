package com.example.sprinprojet.controllers;

// import com.example.sprinprojet.Repository.ReclamationRepository;
import com.example.sprinprojet.model.Reclamation;
import com.example.sprinprojet.model.Client;
import com.example.sprinprojet.service.ReclamationService;
import com.example.sprinprojet.Repository.ClientRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public ReclamationController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

   //   Page ajouterReclamation
    @GetMapping("/ajouterReclamation")
    public String createReclamation(Model model) {
        Reclamation reclamation = new Reclamation();
        model.addAttribute("reclamation", reclamation);
        return "ajouterReclamation";
    }

    @PostMapping("/ajouterReclamation")
    public String saveReclamation(@ModelAttribute("reclamation") Reclamation reclamation, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long clientId = (Long) session.getAttribute("clientId");
        
        Client client = clientRepository.findById(clientId).orElse(null);
        reclamation.setClient(client); // Associer la réclamation au client
        reclamationService.saveReclamation(reclamation);
        
        return "redirect:/consulterReclamation";
    }
    

    //        Page consulterReclamation
    @GetMapping("/consulterReclamation")
    public String consulterReclamation(Model model, HttpServletRequest request) {
        // Récupérer l'ID du client à partir de la session
        HttpSession session = request.getSession();
        Long clientId = (Long) session.getAttribute("clientId");
        
        // Obtenir les réclamations du client
        model.addAttribute("reclamations", reclamationService.getReclamationsByClientId(clientId));
        return "consulterReclamation";
    }


@PostMapping("/consulterReclamation/deleteReclamation/{idReclamation}")
public String deleteReclamation(@PathVariable Long idReclamation) {
    reclamationService.deleteReclamationById(idReclamation);
    return "redirect:/consulterReclamation"; // Assure-toi que c'est le bon nom de la méthode
}


}
