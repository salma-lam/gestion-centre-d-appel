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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AgentController {

    private AgentRepository agentRepository;

    public AgentController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

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
}
