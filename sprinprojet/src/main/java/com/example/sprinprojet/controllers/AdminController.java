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



// package com.example.sprinprojet.controllers;

// import com.example.sprinprojet.Repository.AdminRepository;
// import com.example.sprinprojet.model.Admin;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;


// @Controller
// public class AdminController {

//     private AdminRepository adminRepository;

//     public AdminController(AdminRepository adminRepository) {
//         this.adminRepository = adminRepository;
//     }

//     @GetMapping("/loginAdmin")
//     public String showAdminLoginForm() {
//         return "loginAdmin";
//     }

//     @PostMapping("/loginAdmin")
//     public String loginAdmin(@RequestParam String email, @RequestParam String password, Model model) {
//         Admin admin = adminRepository.findByEmail(email);
//         if (admin != null && admin.getPassword().equals(password)) {
//             // Login successful
//             model.addAttribute("admin", admin);
//             return "admin"; // Redirigez vers le tableau de bord de l'administrateur ou une autre page sécurisée
//         } else {
//             // Login failed
//             model.addAttribute("error", "Email ou mot de passe incorrect");
//             return "loginAdmin";
//         }
//     }
// }



package com.example.sprinprojet.controllers;


import com.example.sprinprojet.Repository.AdminRepository;
import com.example.sprinprojet.service.AdminService;
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



    @GetMapping("/profiladmin")
    public String getlistAdmins(Model model, @RequestParam(value = "success", required = false) String success) {
        List<Admin> adminsList = adminService.getAllAdmins();
        model.addAttribute("admins", adminsList);
        model.addAttribute("success", success);
        System.out.println("Nombre de admins est " + adminsList.size());
        return "profiladmin";
    }

    @GetMapping("/profiladmin/{idAdmin}")
    public String getAdminProfile(@PathVariable Long idAdmin, Model model) {
        model.addAttribute("admin", adminService.getAdminById(idAdmin));
        return "profiladmin";
    }

    @PostMapping("/profiladmin/{idAdmin}")
    public String updateAdminProfile(@PathVariable Long idAdmin, @ModelAttribute("admin") Admin admin) {
        Admin existingAdmin = adminService.getAdminById(idAdmin);
        existingAdmin.setNom(admin.getNom());
        existingAdmin.setPrenom(admin.getPrenom());
        existingAdmin.setEmail(admin.getEmail());
        existingAdmin.setTele(admin.getTele());
        existingAdmin.setAdresse(admin.getAdresse());
        existingAdmin.setGenre(admin.getGenre());

        adminService.updateAdmin(existingAdmin);
        return "redirect:/profiladmin?success=true"; // Redirection vers le profil mis à jour
    }

}




