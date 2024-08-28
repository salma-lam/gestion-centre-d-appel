package com.example.sprinprojet.controllers;

import com.example.sprinprojet.Repository.ClientRepository;
import com.example.sprinprojet.model.Client;
// import com.example.sprinprojet.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;
    // @Autowired
    // private ClientService clientService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Client client = clientRepository.findByEmail(email);
        if (client != null && client.getPassword().equals(password)) {
            // Login successful
            model.addAttribute("client", client);
            return "redirect:/client?idClient=" + client.getId();  //Redirige vers une URL avec l'idClient
        } else {
            // Login failed
            model.addAttribute("error", "Email ou mot de passe incorrect");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }


}
