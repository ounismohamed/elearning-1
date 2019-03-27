package com.example.elearning.rest;

import com.example.elearning.repositories.FormationRepository;
import com.example.elearning.entities.Formation;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("formation")
public class formationRestController {

    //Actions
    private FormationRepository formationRepository;

    public formationRestController(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    @GetMapping()
    public List<Formation> allFormations(){
        return formationRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Formation> findById(@PathVariable("id") int idFormation)
    throws ResourceNotFoundException {
        Formation formation = formationRepository.findById(idFormation)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune formation trouvée avec : " + idFormation));
       return ResponseEntity.ok().body(formation);
        }

    //PS: ResponseEntity represents the whole HTTP response: status code, headers and body.
    @PostMapping
    public ResponseEntity<Formation> addFormation(@Valid @RequestBody Formation formation){
        try {
            formationRepository.save(formation);
            return new ResponseEntity<Formation>(formation, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<Formation>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formation> updateFormation(@PathVariable("id") int idFormation, @RequestBody Formation formationDetails)
    throws ResourceNotFoundException{
        Formation formation = formationRepository.findById(idFormation)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune formation trouvée avec : " + idFormation));
        formation.setDescription(formationDetails.getDescription());
        formation.setDiscipline(formationDetails.getDiscipline());
        formation.setDuree(formationDetails.getDuree());
        formation.setNombremodules(formationDetails.getNombremodules());
        formation.setNomformation(formationDetails.getNomformation());
        //***************
        formation.setApprenants(formationDetails.getApprenants());
        formation.setModules(formationDetails.getModules());
        formation.setFormateurs(formationDetails.getFormateurs());
        //***************
        final Formation updatedFormation = formationRepository.save(formation);
        return ResponseEntity.ok(updatedFormation);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteFormation(@PathVariable("id") int idFormation) throws Exception{
        Formation formation = formationRepository.findById(idFormation)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune formation trouvée avec : " + idFormation));
        formationRepository.delete(formation);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Formation supprimée",Boolean.TRUE);
        return response;
    }
}

