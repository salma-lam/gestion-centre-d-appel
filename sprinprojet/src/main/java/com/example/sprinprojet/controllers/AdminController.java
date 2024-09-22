package com.example.sprinprojet.controllers;


import com.example.sprinprojet.Repository.AdminRepository;
import com.example.sprinprojet.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.example.sprinprojet.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class AdminController {

    private AdminRepository adminRepository;
    private AdminService adminService;

    public AdminController(AdminRepository adminRepository,AdminService adminService) {
        this.adminRepository = adminRepository;
        this.adminService = adminService;
    }

    @GetMapping("/loginAdmin")
    public String showAdminLoginForm() {
        return "loginAdmin"; // Afficher la page de login pour l'admin
    }
    
    @PostMapping("/loginAdmin")
    public String loginAdmin(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            // Connexion réussie
            HttpSession session = request.getSession(); // Obtenir la session courante
            session.setAttribute("adminId", admin.getId()); // Stocker l'ID de l'admin dans la session
    
            model.addAttribute("admin", admin); // Ajouter l'admin au modèle si besoin
            return "redirect:/admin"; // Rediriger vers le tableau de bord de l'admin
        } else {
            // Connexion échouée
            model.addAttribute("error", "Email ou mot de passe incorrect");
            return "loginAdmin"; // Rester sur la page de login avec un message d'erreur
        }
    }


    // Partie profile admin
    @GetMapping("/profiladmin")
    public String getAdminProfile(Model model, HttpServletRequest request, @RequestParam(value = "success", required = false) String success) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long adminId = (Long) session.getAttribute("adminId"); // Récupérer l'ID de l'admin depuis la session
            if (adminId != null) {
                Admin admin = adminService.getAdminById(adminId); // Récupérer l'admin connecté
                model.addAttribute("admin", admin);
                model.addAttribute("success", success);
                return "profiladmin"; // Afficher la page de profil de l'admin
            }
        }
        return "redirect:/login"; // Rediriger vers la page de connexion si non connecté
    }

    @GetMapping("/profiladmin/edit")
    public String editAdminForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long adminId = (Long) session.getAttribute("adminId"); // Récupérer l'ID de l'admin connecté
            if (adminId != null) {
                Admin admin = adminService.getAdminById(adminId);
                model.addAttribute("admin", admin);
                return "editAdmin"; // Afficher le formulaire d'édition du profil admin
            }
        }
        return "redirect:/loginAdmin"; // Rediriger vers la page de connexion si non connecté
    }

    @PostMapping("/profiladmin/{idAdmin}")
    public String updateAdminProfile(@PathVariable Long idAdmin, @ModelAttribute("admin") Admin admin) {
        // Récupérer l'admin existant depuis la base de données
        Admin existingAdmin = adminService.getAdminById(idAdmin);
        if (existingAdmin != null) {
            // Mettre à jour les informations
            existingAdmin.setNom(admin.getNom());
            existingAdmin.setPrenom(admin.getPrenom());
            existingAdmin.setEmail(admin.getEmail());
            existingAdmin.setTele(admin.getTele());
            existingAdmin.setAdresse(admin.getAdresse());
            existingAdmin.setGenre(admin.getGenre());

            // Sauvegarder l'admin mis à jour
            adminService.updateAdmin(existingAdmin);
        }
        return "redirect:/profiladmin?success=true"; // Rediriger après la mise à jour
    }
}



