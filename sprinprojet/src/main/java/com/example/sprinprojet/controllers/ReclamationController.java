package com.example.sprinprojet.controllers;

// import com.example.sprinprojet.Repository.ReclamationRepository;
import com.example.sprinprojet.model.Reclamation;
import com.example.sprinprojet.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;
    // private ReclamationRepository reclamationRepository;


   //   Page ajouterReclamation
    @GetMapping("/ajouterReclamation")
    public String createReclamation(Model model) {
        Reclamation reclamation = new Reclamation();
        model.addAttribute("reclamation", reclamation);
        return "ajouterReclamation";
    }

    @PostMapping("/ajouterReclamation")
    public String saveReclamation(@ModelAttribute("reclamation") Reclamation reclamation) {
        reclamationService.saveReclamation(reclamation);
        return "redirect:/consulterReclamation";
    }

    //        Page consulterReclamation
    @GetMapping("/consulterReclamation")
    public String consulterReclamation(Model model) {
        model.addAttribute("reclamations", reclamationService.getAllReclamations());
        return "consulterReclamation";
    }

   // Action supprimer reclamation
//   @PostMapping("/consulterReclamation/deleteReclamation/{idReclamation}")
//   public String deleteReclamation(@PathVariable Long idReclamation) {
//       reclamationService.deleteReclamationById(idReclamation);
//       return "redirect:/consulReclamation";
//   }



}
