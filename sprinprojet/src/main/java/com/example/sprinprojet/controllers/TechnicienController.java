//package com.example.sprinprojet.controllers;
//
//import com.example.sprinprojet.Repository.TechnicienRepository;
//import com.example.sprinprojet.model.Technicien;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class TechnicienController {
//
//    private TechnicienRepository technicienRepository;
//
//    public TechnicienController(TechnicienRepository technicienRepository) {
//        this.technicienRepository = technicienRepository;
//    }
//
//    @GetMapping("/loginTechnicien")
//    public String showTechnicienLoginForm() {
//        return "loginTechnicien";
//    }
//
//    @PostMapping("/loginTechnicien")
//    public String loginTechnicien(@RequestParam String email, @RequestParam String password, Model model) {
//        Technicien technicien = technicienRepository.findByEmail(email);
//        if (technicien != null && technicien.getPassword().equals(password)) {
//            // Login successful
//            model.addAttribute("technicien", technicien);
//            return "technicien"; // Redirigez vers le tableau de bord du technicien ou une autre page sécurisée
//        } else {
//            // Login failed
//            model.addAttribute("error", "Email ou mot de passe incorrect");
//            return "loginTechnicien";
//        }
//    }
//}
