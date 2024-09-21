// package com.example.sprinprojet.controllers;

// import com.example.sprinprojet.model.Client;
// import com.example.sprinprojet.service.ClientService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @Controller
// public class Controllerclient {
//     @Autowired
//     private ClientService clientService;
//     public Controllerclient(ClientService clientService) {
//         this.clientService = clientService;
//     }
//     @GetMapping("/profileclient")
//     public String getlistClients(Model model, @RequestParam(value = "success", required = false) String success) {
//         List<Client> clientsList = clientService.getAllClients();
//         model.addAttribute("clients", clientsList);
//         model.addAttribute("success", success);
//         System.out.println("Nombre de clients est " + clientsList.size());
//         return "profileclient";
//     }

//     @GetMapping("/profileclient/{idClient}")
//     public String editClientForm(@PathVariable Long idClient, Model model) {
//         model.addAttribute("client", clientService.getClientById(idClient));
//         return "profileclient";
//     }

//     @PostMapping("/profileclient/{idClient}")
//     public String updateClient(@PathVariable Long idClient, @ModelAttribute("client") Client client) {
//         // get client from database by id
//         Client existingClient = clientService.getClientById(idClient);
//         existingClient.setNom(client.getNom());
//         existingClient.setPrenom(client.getPrenom());
//         existingClient.setEmail(client.getEmail());
//         existingClient.setTele(client.getTele());
//         existingClient.setAdresse(client.getAdresse());
//         existingClient.setGenre(client.getGenre());

//         // save updated client object
//         clientService.updateClient(existingClient);
//         return "redirect:/profileclient?success=true";
//     }
// }
