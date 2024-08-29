//package com.example.sprinprojet.controllers;
//
//import com.example.sprinprojet.Repository.AgentRepository;
//import com.example.sprinprojet.model.Agent;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@Controller
//public class AgentController {
//
//    private AgentRepository agentRepository;
//
//    public AgentController(AgentRepository agentRepository) {
//        this.agentRepository = agentRepository;
//    }
//
//    @GetMapping("/loginAgent")
//    public String showAgentLoginForm() {
//        return "loginAgent";
//    }
//
//    @PostMapping("/loginAgent")
//    public String loginAgent(@RequestParam String email, @RequestParam String password, Model model) {
//        Agent agent = agentRepository.findByEmail(email);
//        if (agent != null && agent.getPassword().equals(password)) {
//            // Login successful
//            model.addAttribute("agent", agent);
//            return "agent" + agent.getId();  //Redirige vers une URL avec l'idAgent
//        } else {
//            // Login failed
//            model.addAttribute("error", "Email ou mot de passe incorrect");
//            return "loginAgent";
//        }
//    }
//}


package com.example.sprinprojet.controllers;

import com.example.sprinprojet.Repository.AgentRepository;
import com.example.sprinprojet.model.Agent;
import com.example.sprinprojet.service.AgentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AgentController {

    private AgentRepository agentRepository;
    private AgentService agentService;

    public AgentController(AgentRepository agentRepository, AgentService agentService) {
        this.agentRepository = agentRepository;
        this.agentService = agentService;    }

    @GetMapping("/loginAgent")
    public String showAgentLoginForm() {
        return "loginAgent";
    }

    @PostMapping("/loginAgent")
    public String loginAgent(@RequestParam String email, @RequestParam String password, Model model) {
        Agent agent = agentRepository.findByEmail(email);
        if (agent != null && agent.getPassword().equals(password)) {
            // Login successful
            model.addAttribute("agent", agent);
            return "agent"; // Redirigez vers le tableau de bord de l'agent ou une autre page sécurisée
        } else {
            // Login failed
            model.addAttribute("error", "Email ou mot de passe incorrect");
            return "loginAgent";
        }
    }

    // handler method to handle list agents and return mode and view
    @GetMapping("/listeagent")
    public String getAllAgents(Model model) {
        model.addAttribute("agents", agentService.getAllAgents());
        return "listeagent";
    }

    @GetMapping("/listeagent/ajouteragent")
    public String createAgent (Model model){
        //create agent object to hold agent  form data
        Agent agent = new Agent();
        model.addAttribute("agent",agent);
        return "ajouteragent";
    }

    @PostMapping("/listeagent")
    public String saveAgent(@ModelAttribute("agent") Agent agent) {
        agentService.saveAgent(agent);
        return "redirect:/listeagent";
    }


    @GetMapping("/editagent/{idAgent}")
    public String editAgentForm(@PathVariable Long idAgent, Model model){
        model.addAttribute("agent",agentService.getAgentById(idAgent));
        return "editagent";
    }

    @PostMapping("/listeagent/{idAgent}")
    public String updateAgent(@PathVariable Long idAgent,
                              @ModelAttribute("agent") Agent agent,
                              Model model) {

        //get agent from database by id
        Agent existingAgent = agentService.getAgentById(idAgent);

        existingAgent.setNom(agent.getNom());
        existingAgent.setPrenom(agent.getPrenom());
        existingAgent.setTele(agent.getTele());
        existingAgent.setEmail(agent.getEmail());
        existingAgent.setAdresse(agent.getAdresse());
        existingAgent.setPassword(agent.getPassword());
        existingAgent.setDatenaissance(agent.getDatenaissance());
        existingAgent.setGenre(agent.getGenre());

        //save updated agent object
        agentService.updateAgent(existingAgent);
        return "redirect:/listeagent";

    }


// handler method to handle delete student request

    @PostMapping("/listeagent/delete/{idAgent}")
    public String deleteAgent(@PathVariable Long idAgent) {
        agentService.deleteAgentById(idAgent);
        return "redirect:/listeagent";
    }



}
