package com.example.elearning.rest;

import com.example.elearning.entities.Module;
import com.example.elearning.repositories.ModuleRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("module")
public class moduleRestController {
    //Actions
    private ModuleRepository moduleRepository;

    public moduleRestController(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @GetMapping()
    public List<Module> allModules(){
        return moduleRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Module> findById(@PathVariable("id") int idModule)
            throws ResourceNotFoundException {
        Module module = moduleRepository.findById(idModule)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun module trouvé avec : " + idModule));
        return ResponseEntity.ok().body(module);
    }

    @PostMapping
    public ResponseEntity<Module> addModule(@Valid @RequestBody Module module){
        try {
            moduleRepository.save(module);
            return new ResponseEntity<Module>(module, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<Module>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable("id") int idModule, @RequestBody Module moduleDetails)
            throws ResourceNotFoundException {
        Module module = moduleRepository.findById(idModule)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun module trouvé avec : " + idModule));
        module.setDescription(moduleDetails.getDescription());
        module.setDuree(moduleDetails.getDuree());
        module.setNom(moduleDetails.getNom());
        module.setNbrchapitre(moduleDetails.getNbrchapitre());
        module.setTyperessource(moduleDetails.getTyperessource());
        //***************
        module.setChapitres(moduleDetails.getChapitres());
        module.setFormateur(moduleDetails.getFormateur());
        module.setFormation(moduleDetails.getFormation());
        module.setRessources(moduleDetails.getRessources());
        module.setApprenants(moduleDetails.getApprenants());
        //***************
        final Module updatedModule = moduleRepository.save(module);
        return ResponseEntity.ok(updatedModule);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteModule(@PathVariable("id") int idModule) throws Exception{
        Module module = moduleRepository.findById(idModule)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun module trouvé avec : " + idModule));
        moduleRepository.delete(module);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Module supprimé",Boolean.TRUE);
        return response;
    }

}
