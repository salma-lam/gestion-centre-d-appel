package com.example.sprinprojet.controllers;

import com.example.sprinprojet.model.Client;
import com.example.sprinprojet.service.ClientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Afficher la liste des clients
    @GetMapping("/listeClient")
    public String showClientList(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "listeClient"; 
    }
    
    // Afficher le formulaire d'enregistrement
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "register"; 
    }
    // Enregistrer un client
    @PostMapping("/register")
    public String registerClient(@ModelAttribute("client") Client client, Model model) {
        if (clientService.emailExists(client.getEmail())) {
            model.addAttribute("emailError", "Email déjà inscrit");
            model.addAttribute("client", client);
            return "register";
        }
        clientService.saveClient(client);
        return "redirect:/login";
    }

    // Afficher le profil du client connecté
    @GetMapping("/profileclient")
    public String getClientProfile(Model model, HttpServletRequest request, @RequestParam(value = "success", required = false) String success) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long clientId = (Long) session.getAttribute("clientId");
            if (clientId != null) {
                Client client = clientService.getClientById(clientId);
                model.addAttribute("client", client);
                model.addAttribute("success", success);
                return "profileclient";
            }
        }
        return "redirect:/login"; // Rediriger vers la page de connexion si l'utilisateur n'est pas connecté
    }

    // Modifier un client
    @GetMapping("/profileclient/edit")
    public String editClientForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long clientId = (Long) session.getAttribute("clientId");
            if (clientId != null) {
                Client client = clientService.getClientById(clientId);
                model.addAttribute("client", client);
                return "editClient"; // Afficher le formulaire d'édition
            }
        }
        return "redirect:/login"; // Rediriger vers la page de connexion
    }

    // Mise à jour d'un client
    @PostMapping("/profileclient/{idClient}")
    public String updateClient(@PathVariable Long idClient, @ModelAttribute("client") Client client) {
        // Récupérer le client existant depuis la base de données par son ID
        Client existingClient = clientService.getClientById(idClient);
        if (existingClient != null) {
            // Mettre à jour les informations
            existingClient.setNom(client.getNom());
            existingClient.setPrenom(client.getPrenom());
            existingClient.setEmail(client.getEmail());
            existingClient.setTele(client.getTele());
            existingClient.setAdresse(client.getAdresse());
            existingClient.setGenre(client.getGenre());

            // Sauvegarder l'objet client mis à jour
            clientService.updateClient(existingClient);
        }
        return "redirect:/profileclient?success=true"; // Rediriger après la mise à jour
    }

    @GetMapping("/client")
    public String dashboard(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("clientId") == null) {
            return "redirect:/"; // Redirect to home page if not logged in
        }
            return "client"; 
    }


    // @PostMapping("/listeClient/delete/{idClient}")
    // public String deleteClient(@PathVariable Long idClient) {
    //     clientService.deleteClientById(idClient);
    //     return "redirect:/listeClient";
    // }
    
    


}
