package com.example.sprinprojet.controllers;

import com.example.sprinprojet.model.Client;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {
//    @GetMapping("/index")
//    public String index(){
//        return"index";
//        //
//    }

    @GetMapping("/index")
    public String home(HttpSession session, Model model) {
        Client client = (Client) session.getAttribute("client");
        if (client == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("client", client);
        return "index";
    }
//    @GetMapping("/loginAdmin")
//    public String loginAdmin(){
//        return"loginAdmin";
//        //
//    }
//    @GetMapping("/loginAgent")
//    public String loginAgent(){
//        return"loginAgent";
//        //
//    }
//    @GetMapping("/loginTechnicien")
//    public String loginTechnicien(){
//        return"loginTechnicien";
//        //
//    }
//    @GetMapping("/register")
//    public String register(){
//        return"register";
//        //
//    }
    @GetMapping("/agent")
    public String Agent(){
        return"agent";
        //
    }
    // @GetMapping("/consulterTicket")
    // public String consulterTicket(){
    //     return"consulterTicket";
    //     //
    // }
    // @GetMapping("/modifierProfile")
    // public String modifierProfile(){
    //     return"modifierProfile";
    //     //
    // }   

     @GetMapping("/profilagent")
    public String profilagent(){
        return"profilagent";
        //
    }
    @GetMapping("/client")
    public String client(){
        return"client";
        //
    }
//    @GetMapping("/consulterReclamation")
//    public String consulterReclamationt(){
//        return"consulterReclamation";
//        //
//    }
//    @GetMapping("/ajouterReclamation")
//    public String ajouterReclamation(){
//        return"ajouterReclamation";
//        //
//    }
//    @GetMapping("/profileclient")
//    public String profileclient(){
//        return "profileclient";
//        //
//    }
//    @GetMapping("/admin")
//    public String Admin(){
//        return"admin";
//        //
//    }
    // @GetMapping("/listeClient")
    // public String listeClient(){
    //     return"listeClient";
    //     //
    // }
    @GetMapping("/listeTicket")
    public String listeTicket(){
        return"listeTicket";
        //
    }
    // @GetMapping("/profiladmin")
    // public String profiladmin(){
    //     return"profiladmin";
    //     //
    // }
    @GetMapping("/ajouteragent")
    public String  ajouteragent(){
        return"ajouteragent";
        //
    }
    // @GetMapping("/listeagent")
    // public String listeagent(){
    //     return"listeagent";
    //     //
    // }
    @GetMapping("/ajouterTechnicien")
    public String ajouterTechnicien(){
        return"ajouterTechnicien";
        //
    }
    @GetMapping("/listeTechnicien")
    public String listeTechnicien(){
        return"listeTechnicien";
        //
    }
}
