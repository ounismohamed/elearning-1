package com.example.elearning.web;

import com.example.elearning.entities.Formation;
import com.example.elearning.entities.Module;
import com.example.elearning.metier.IElearning;
import com.example.elearning.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class mainController {
    @Autowired
    private IElearning iElearning;
    @Autowired
    private FormationRepository formationRepository;

    @GetMapping("/catalogue")
    public String home(){
        return "catalogue";
    }

    @GetMapping("/consulterFormation")
    public String consulterFormation(Model model, int idFormation){
        model.addAttribute("idFormation",idFormation);
        try {
            Optional<Formation> formation=iElearning.consulterFormation(idFormation);
            Page<Formation> formationPage = iElearning.listFormation(0,10);
            Page<Module> modulePage = iElearning.listModule(0,5);
            model.addAttribute("listModule",modulePage.getContent());
            model.addAttribute("listFormation",formationPage.getContent());
            model.addAttribute("formation",formation);
            int pageCount = formationPage.getTotalPages();
            int[] pages = new int[pageCount];
            for (int i=0;i<pageCount;i++) pages[i]=i;
            model.addAttribute("pages",pages);
        }
        catch (Exception e){
            model.addAttribute("exception",e);      //exception stockee dans le model, sera affiche dans la vue
        }
        return "catalogue";
    }
    @GetMapping("/apropos")
    public String apropos(){
        return "apropos";
    }

    @GetMapping("/accueil")
    public String index(){
        return "accueil";
    }

    @GetMapping("/inscription")
    public String inscription(){
        return "inscription";
    }

    @GetMapping("/identification")
    public String identification(){
        return "identification";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

}
