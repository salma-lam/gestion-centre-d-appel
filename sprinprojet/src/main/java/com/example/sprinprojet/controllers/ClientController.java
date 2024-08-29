package com.example.sprinprojet.controllers;

import com.example.sprinprojet.model.Client;
import com.example.sprinprojet.service.ClientService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    // private final ClientService clientService;

    public ClientController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }

    @GetMapping("/listeClient")
    public String showClientList(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "listeClient"; // This should match the name of your Thymeleaf template without the .html extension
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "register"; // Assurez-vous que le fichier s'appelle register.html
    }

    @PostMapping("/register")
    public String registerClient(@ModelAttribute("client") Client client, Model model) {
        if (clientService.emailExists(client.getEmail())) {
            model.addAttribute("emailError", "Email déjà inscrit");
            model.addAttribute("client", client);
            return "register";
        }
        clientService.saveClient(client);
        return "redirect:/login"; // Redirige vers la page de connexion après l'inscription
    }


}
