//package com.example.sprinprojet.controllers;
//
//import com.example.sprinprojet.Repository.AdminRepository;
//import com.example.sprinprojet.model.Admin;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@Controller
//public class AdminController {
//
//    private final AdminRepository adminRepository;
//
//    public AdminController(AdminRepository adminRepository) {
//        this.adminRepository = adminRepository;
//    }
//
//    @GetMapping("/loginAdmin")
//    public String showAdminLoginForm() {
//        return "loginAdmin";
//    }
//
//    @PostMapping("/loginAdmin")
//    public String loginAdmin(@RequestParam String email, @RequestParam String password, Model model) {
//        Admin admin = adminRepository.findByEmail(email);
//        if (admin != null && admin.getPassword().equals(password)) {
//            // Login successful
//            model.addAttribute("admin", admin);
//            return "admin";  //Redirige vers une URL avec l'idAdmin
//        } else {
//            // Login failed
//            model.addAttribute("error", "Email ou mot de passe incorrect");
//            return "loginAdmin";
//        }
//    }
//}



package com.example.sprinprojet.controllers;

import com.example.sprinprojet.Repository.AdminRepository;
import com.example.sprinprojet.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController {

    private AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/loginAdmin")
    public String showAdminLoginForm() {
        return "loginAdmin";
    }

    @PostMapping("/loginAdmin")
    public String loginAdmin(@RequestParam String email, @RequestParam String password, Model model) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            // Login successful
            model.addAttribute("admin", admin);
            return "admin"; // Redirigez vers le tableau de bord de l'administrateur ou une autre page sécurisée
        } else {
            // Login failed
            model.addAttribute("error", "Email ou mot de passe incorrect");
            return "loginAdmin";
        }
    }
}


