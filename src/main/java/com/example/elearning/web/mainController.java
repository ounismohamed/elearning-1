package com.example.elearning.web;

import com.example.elearning.entities.Formation;
import com.example.elearning.metier.IElearning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Controller
public class mainController {
    @Autowired
    private IElearning iElearning;

    @GetMapping("/accueil")
    public String home(){
        return "accueil";
    }

    @GetMapping("/consulterFormation")
    public String consulterFormation(Model model, int idFormation){
        try {
            Optional<Formation> formation=iElearning.consulterFormation(idFormation);
            model.addAttribute("formation",formation);
        }
        catch (Exception e){
            model.addAttribute("exception",e);      //exception stockee dans le model, sera affiche dans la vue
        }
        return "accueil";
    }


}
