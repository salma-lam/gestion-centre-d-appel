package com.example.sprinprojet.service;

// import com.example.sprinprojet.Repository.ClientRepository;
import com.example.sprinprojet.Repository.TicketRepository;
import com.example.sprinprojet.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    // @Autowired
    // private ClientRepository clientRepository;

    public Ticket getTicketById(Long idTicket) {
        return ticketRepository.findById(idTicket).orElse(null);
    }
    public Ticket updateTicket(Ticket ticket) {
        return  ticketRepository.save(ticket);
    }



}