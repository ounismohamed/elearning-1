package com.example.elearning.web;

import com.example.elearning.entities.*;
import com.example.elearning.entities.Module;
import com.example.elearning.metier.IElearning;
import com.example.elearning.repositories.*;
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
    private ContactRepository contactRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private FormateurRepository formateurRepository;
    @Autowired
    private ApprenantRepository apprenantRepository;


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


    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String listformationsAdmin(Model model,
                                 @RequestParam(name="page",defaultValue = "0") int page,
                                 @RequestParam(name="motCle",defaultValue = "") String mc){
        Page<Formation> formation=formationRepository.findByDesignationContains(String.format("%%%s%%", mc),PageRequest.of(page,5));
        model.addAttribute("listformations",formation.getContent());
        model.addAttribute("pages",new int[formation.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("motCle",mc);

        return "admin";
    }

    @RequestMapping(value = "/adminFormateurs",method = RequestMethod.GET)
    public String listformateursAdmin(Model model,
                                 @RequestParam(name="actualPage",defaultValue = "0") int currentPage,
                                 @RequestParam(name="motCle",defaultValue = "") String mc){
        Page<Formateur> formateurs=formateurRepository.findByDesignationFormateur("%"+mc+"%",PageRequest.of(currentPage,5));
        model.addAttribute("listformateurs",formateurs.getContent());
        model.addAttribute("pages",new int[formateurs.getTotalPages()]);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("motCle",mc);

        return "adminFormateurs";
    }

    @RequestMapping(value = "/adminApprenants",method = RequestMethod.GET)
    public String listapprenantsAdmin(Model model,
                                      @RequestParam(name="currentPage",defaultValue = "0") int currentPage,
                                      @RequestParam(name="motCle",defaultValue = "") String mc){
        Page<Apprenant> apprenants=apprenantRepository.findByDesignationApprenant("%"+mc+"%",PageRequest.of(currentPage,5));
        model.addAttribute("listapprenants",apprenants.getContent());
        model.addAttribute("pages",new int[apprenants.getTotalPages()]);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("motCle",mc);

        return "adminApprenants";
    }

    @RequestMapping(value = "/adminSuppFormateur",method = RequestMethod.GET)
    public String suppFormateur(Model model,
                                      @RequestParam(name="page",defaultValue = "0") int page,
                                      @RequestParam(name="motCle",defaultValue = "") String mc){
        Page<Formateur> formateurs=formateurRepository.findByDesignationFormateur(String.format("%%%s%%", mc),PageRequest.of(page,5));
        model.addAttribute("listformateurs",formateurs.getContent());
        model.addAttribute("pages",new int[formateurs.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("motCle",mc);

        return "admin";
    }

    @GetMapping("/delete")
    public String delete(int id, int page, String motCle){
        formationRepository.deleteById(id);
        return "redirect:/admin?page="+page+"&motCle="+motCle;
    }

    @GetMapping("/deleteApprenant")
    public String deleteApprenant(int id, int page, String motCle){
        apprenantRepository.deleteById(id);
        return "redirect:/adminApprenants?page="+page+"&motCle="+motCle;
    }

    @GetMapping("/deleteFormateur")
    public String deleteFormateur(int id, int page, String motCle){
        formateurRepository.deleteById(id);
        return "redirect:/adminFormateurs?page="+page+"&motCle="+motCle;
    }

    @RequestMapping(value = "/inscription",method = RequestMethod.GET)
    public String formInscription(Model model){
        model.addAttribute("formateur",new Formateur());
        model.addAttribute("apprenant",new Apprenant());
        return "inscription";
    }

    @RequestMapping(value = "/saveFA",method = RequestMethod.POST)
    public String saveProfile(Model model, String choix, Formateur formateur,Apprenant apprenant){
        try{
            if (choix.equals("ajoutFormateur")) {
                profileRepository.save(formateur);
            }
            else if (choix.equals("ajoutApprenant")){
                profileRepository.save(apprenant);
            }
        }
        catch (Exception e)
        {
            model.addAttribute("Erreur d'inscription",e);
        }

        return "/saveInscriptionFormateur";
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

    @RequestMapping(value = "/ajoutSuppFormation",method = RequestMethod.GET)
    public String ajoutSuppFormation(Model model){
        model.addAttribute("formation",new Formation());
        return "ajoutSuppFormation";
    }

    @RequestMapping(value = "/saveFormation",method = RequestMethod.POST)
    public String ajoutFormation(Formation formation){
            formationRepository.save(formation);
        return "saveInscriptionFormateur";
    }

    @GetMapping("/saveInscriptionFormateur")
    public String ajoutSuppFormation(){
        return "ajoutSuppFormation";
    }



}