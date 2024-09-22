// package com.example.sprinprojet.controllers;

// import com.example.sprinprojet.Repository.ClientRepository;
// import com.example.sprinprojet.model.Client;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpSession;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private ClientRepository clientRepository;

//     @GetMapping("/login")
//     public String showLoginForm() {
//         return "login"; // Assurez-vous d'avoir un fichier login.html dans templates
//     }

//     @PostMapping("/login")
//     public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
//         Client client = clientRepository.findByEmail(email);
//         if (client != null && client.getPassword().equals(password)) {
//             session.setAttribute("client", client);
//             return "redirect:/client";
//         } else {
//             model.addAttribute("error", "Email ou mot de passe incorrect");
//             return "login";
//         }
//     }

//     @GetMapping("/logout")
//     public String logout(HttpServletRequest request) {
//         HttpSession session = request.getSession(false);
//         if (session != null) {
//             session.invalidate();
//         }
//         return "redirect:/index";
//     }
// }
