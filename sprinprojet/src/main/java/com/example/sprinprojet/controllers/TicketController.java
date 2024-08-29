package com.example.sprinprojet.controllers;

import com.example.sprinprojet.Repository.ClientRepository;
// import com.example.sprinprojet.Repository.ReclamationRepository;
import com.example.sprinprojet.Repository.TicketRepository;
import com.example.sprinprojet.model.Client;
import com.example.sprinprojet.model.Ticket;
import com.example.sprinprojet.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class TicketController {
    @Autowired
    private TicketRepository ticketRepo;
    @Autowired
    private ClientRepository clientRepo;
    // @Autowired
    // private ReclamationRepository reclamationRepository;
    @Autowired
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }



    @GetMapping("/consulterTicket")
    public String consulterTicket(Model model) {
        List<Ticket> tickets = ticketRepo.findAll();
        List<Client> Clients = clientRepo.findAll();
        model.addAttribute("tickets", tickets );
        model.addAttribute("Clients", Clients );
        return "consulterTicket";
    }

    @GetMapping("/AddInfo")
    public String addInfo(Model model){
        Ticket ticket = new Ticket();
        model.addAttribute("tickit", ticket);
        return "AddInfo"; // Updated to match the form view name
    }

    @PostMapping("/saveTickit")
    public String saveTickit(@ModelAttribute("tickit") Ticket ticket){
        ticketRepo.save(ticket);
        return "redirect:/consulterTicket";
    }
    @GetMapping("/AddInfo/{idTicket}")
    public String editTicket(@PathVariable Long idTicket, Model model) {
        model.addAttribute("ticket", ticketService.getTicketById(idTicket));
        return "AddInfo";
    }

    @PostMapping("/consulterTicket/{idTicket}")
    public String updateTicket(@PathVariable Long idTicket, @ModelAttribute("ticket") Ticket ticket) {
        Ticket existingTicket = ticketService.getTicketById(idTicket);
        existingTicket.setDateCloture(ticket.getDateCloture());
        existingTicket.setStatut(ticket.getStatut());
        ticketService.updateTicket(existingTicket);
        return "redirect:/consulterTicket";
    }

    @PostMapping("/deleteTicket/{idTicket}")
    public String deleteTicket(@PathVariable("idTicket") Long idTicket) {
        ticketRepo.deleteById(idTicket);
        return "redirect:/consulterTicket";
    }

}