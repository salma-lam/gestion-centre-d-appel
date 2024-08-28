package com.example.sprinprojet.controllers;


import com.example.sprinprojet.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/admin")
    public String getDashboardStatistics(Model model) {
        long numberOfReclamations = dashboardService.getNumberOfReclamations();
        long numberOfClients = dashboardService.getNumberOfClients();
        long numberOfAdmins = dashboardService.getNumberOfAdmins();
        long numberOfAgents = dashboardService.getNumberOfAgents();
        long numberOfTickets = dashboardService.getNumberOfTickets();

        model.addAttribute("numberOfReclamations", numberOfReclamations);
        model.addAttribute("numberOfClients", numberOfClients);
        model.addAttribute("numberOfAdmins", numberOfAdmins);
        model.addAttribute("numberOfAgents", numberOfAgents);
        model.addAttribute("numberOfTickets", numberOfTickets);

        return "admin";
    }
}
