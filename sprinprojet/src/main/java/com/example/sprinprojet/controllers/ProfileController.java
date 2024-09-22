package com.example.sprinprojet.controllers;

import com.example.sprinprojet.model.Agent;
import com.example.sprinprojet.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfileController {
    // @Autowired
    // private AgentService agentService;
    // public ProfileController(AgentService agentService) {
    //     this.agentService = agentService;
    // }
    // @GetMapping("/profileagent")
    // public String getlistAgents(Model model, @RequestParam(value = "success", required = false) String success) {
    //     List<Agent> agentList = agentService.getAllAgents(); 
    //     model.addAttribute("agents", agentList);
    //     model.addAttribute("success", success);
    //     System.out.println("Nombre d'agents est " + agentList.size());
    //     return "profileagent";
    // }
    
    // @GetMapping("/profileagent/{idAgent}")
    // public String editAgenttForm(@PathVariable Long idAgent, Model model) {
    //     model.addAttribute("agent", agentService.getAgentById(idAgent));
    //     return "profileagent";
    // }
    // @PostMapping("/profileagent/{idAgent}")
    // public String updateClient(@PathVariable Long idAgent, @ModelAttribute("agent") Agent agent) {
    //     // get client from database by id
    //     Agent existingAgent = agentService.getAgentById(idAgent);
    //     existingAgent.setNom(agent.getNom());
    //     existingAgent.setPrenom(agent.getPrenom());
    //     existingAgent.setEmail(agent.getEmail());
    //     existingAgent.setTele(agent.getTele());
    //     existingAgent.setAdresse(agent.getAdresse());
    //     existingAgent.setGenre(agent.getGenre());

    //     // save updated client object
    //     agentService.updateAgent(existingAgent);
    //     return "redirect:/profileagent?success=true";
    // }


}


