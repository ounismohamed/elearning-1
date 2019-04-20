package com.example.elearning.web;

import com.example.elearning.entities.*;
import com.example.elearning.entities.Module;
import com.example.elearning.metier.IElearning;
import com.example.elearning.repositories.ContactRepository;
import com.example.elearning.repositories.FormationRepository;
import com.example.elearning.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;


@Controller
public class mainController {
    @Autowired
    private IElearning iElearning;
    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/notrecatalogue")
    public String home(){
        return "catalogue";
    }

    @GetMapping("/consulterFormation")
    public String consulterFormation(Model model, int idFormation){
        model.addAttribute("idFormation",idFormation);
        try {
            Optional<Formation> formation=iElearning.consulterFormation(idFormation);
            /*Page<Formation> formationPage = iElearning.listFormation(0,10);*/
            /*Page<Module> modulePage = iElearning.listModule(0,5);*/
            Page<Module> pageModule = iElearning.pageModule(idFormation,0,5);
            model.addAttribute("pageModule",pageModule.getContent());
            /*model.addAttribute("listModule",modulePage.getContent());*/
           /* model.addAttribute("listFormation",formationPage.getContent());*/
            model.addAttribute("formation",formation);
            List<Formation> formations=formationRepository.findAll();
            model.addAttribute("listformations",formations);

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

    @GetMapping("/")
    public String ind(){
        return "accueil";
    }

    @GetMapping("/accueil")
    public String index(){
        return "accueil";
    }

    @GetMapping("/identification")
    public String identification(){
        return "identification";
    }

    /*@GetMapping("/contact")
    public String contact(){
        return "contact";
    }*/

    /*@RequestMapping(value="/form",method = RequestMethod.GET)
    public String formInscription(){
        return "inscription";
    }*/

    @RequestMapping(value = "/catalogue",method = RequestMethod.GET)
    public String listformations(Model model,
                                 @RequestParam(name="page",defaultValue = "0") int page,
                                 @RequestParam(name="motCle",defaultValue = "") String mc){
        Page<Formation> formation=formationRepository.findByDesignationContains("%"+mc+"%",PageRequest.of(page,5));
        model.addAttribute("listformations",formation.getContent());
        /*Page<Formation> formationPage = iElearning.listFormation(0,10);*/
        model.addAttribute("pages",new int[formation.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("motCle",mc);

        return "catalogue";
    }

    @GetMapping("/delete")
    public String delete(int id, int page, String motCle){
        formationRepository.deleteById(id);
        return "redirect:/catalogue?page="+page+"&motCle="+motCle;
    }

    @RequestMapping(value = "inscription",method = RequestMethod.GET)
    public String formInscription(Model model){
        model.addAttribute("formateur",new Formateur());
        return "inscription";
    }

    @RequestMapping(value = "/saveProfile",method = RequestMethod.POST)
    public String saveProfile(Model model, String choix,
                              String nom, String email, String identifiant,
                              String motdepasse, String anciennete,
                              String domaine, Formateur formateur){
        try{
            if (choix.equals("ajoutFormateur")) {
                profileRepository.save(formateur);
            }
        }
        catch (Exception e)
        {
            model.addAttribute("Erreur d'inscription",e);
        }

        return "redirect:/inscription";
    }

    @RequestMapping(value = "/contact",method = RequestMethod.GET)
    public String formContact(Model model){
        model.addAttribute("mmmm",new Contact());
        return "contact";
    }

    @RequestMapping(value = "/saveContact",method = RequestMethod.POST)
    public String saveContact(Contact contact){
        contactRepository.save(contact);
        return "/saveContact";
    }
}
