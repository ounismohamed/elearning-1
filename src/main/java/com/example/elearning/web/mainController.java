package com.example.elearning.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/accueil")
    public String home(){
        return "accueil";
    }
}
