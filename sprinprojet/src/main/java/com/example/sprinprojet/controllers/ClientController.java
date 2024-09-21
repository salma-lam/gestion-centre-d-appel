// package com.example.sprinprojet.controllers;

// import com.example.sprinprojet.model.Client;
// import com.example.sprinprojet.service.ClientService;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.*;


// @Controller
// public class ClientController {

//     @Autowired
//     private ClientService clientService;

//     // private final ClientService clientService;

//     public ClientController(ClientService clientService) {
//         super();
//         this.clientService = clientService;
//     }

//     @GetMapping("/listeClient")
//     public String showClientList(Model model) {
//         List<Client> clients = clientService.getAllClients();
//         model.addAttribute("clients", clients);
//         return "listeClient"; 
//     }
    
//     @GetMapping("/register")
//     public String showRegistrationForm(Model model) {
//         Client client = new Client();
//         model.addAttribute("client", client);
//         return "register"; 
//     }

//     @PostMapping("/register")
//     public String registerClient(@ModelAttribute("client") Client client, Model model) {
//         if (clientService.emailExists(client.getEmail())) {
//             model.addAttribute("emailError", "Email déjà inscrit");
//             model.addAttribute("client", client);
//             return "register";
//         }
//         clientService.saveClient(client);
//         return "redirect:/login";



//         // Partie de l'agent

//         @GetMapping("/profileclient")
//         public String getlistClients(Model model, @RequestParam(value = "success", required = false) String success) {
//             List<Client> clientsList = clientService.getAllClients();
//             model.addAttribute("clients", clientsList);
//             model.addAttribute("success", success);
//             System.out.println("Nombre de clients est " + clientsList.size());
//             return "profileclient";
//         }
    
//         @GetMapping("/profileclient/{idClient}")
//         public String editClientForm(@PathVariable Long idClient, Model model) {
//             model.addAttribute("client", clientService.getClientById(idClient));
//             return "profileclient";
//         }
    
//         @PostMapping("/profileclient/{idClient}")
//         public String updateClient(@PathVariable Long idClient, @ModelAttribute("client") Client client) {
//             // get client from database by id
//             Client existingClient = clientService.getClientById(idClient);
//             existingClient.setNom(client.getNom());
//             existingClient.setPrenom(client.getPrenom());
//             existingClient.setEmail(client.getEmail());
//             existingClient.setTele(client.getTele());
//             existingClient.setAdresse(client.getAdresse());
//             existingClient.setGenre(client.getGenre());
    
//             // save updated client object
//             clientService.updateClient(existingClient);
//             return "redirect:/profileclient?success=true";
//         }
    
// }



package com.example.sprinprojet.controllers;

import com.example.sprinprojet.model.Client;
import com.example.sprinprojet.service.ClientService;
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

    // Partie de l'agent : Liste des clients
    @GetMapping("/profileclient")
    public String getlistClients(Model model, @RequestParam(value = "success", required = false) String success) {
        List<Client> clientsList = clientService.getAllClients();
        model.addAttribute("clients", clientsList);
        model.addAttribute("success", success);
        System.out.println("Nombre de clients est " + clientsList.size());
        return "profileclient";
    }

    // Modifier un client
    @GetMapping("/profileclient/{idClient}")
    public String editClientForm(@PathVariable Long idClient, Model model) {
        model.addAttribute("client", clientService.getClientById(idClient));
        return "profileclient";
    }

    // Mise à jour d'un client
    @PostMapping("/profileclient/{idClient}")
    public String updateClient(@PathVariable Long idClient, @ModelAttribute("client") Client client) {
        // Récupérer le client depuis la base de données par son ID
        Client existingClient = clientService.getClientById(idClient);
        existingClient.setNom(client.getNom());
        existingClient.setPrenom(client.getPrenom());
        existingClient.setEmail(client.getEmail());
        existingClient.setTele(client.getTele());
        existingClient.setAdresse(client.getAdresse());
        existingClient.setGenre(client.getGenre());

        // Sauvegarder l'objet client mis à jour
        clientService.updateClient(existingClient);
        return "redirect:/profileclient?success=true";
    }
}
