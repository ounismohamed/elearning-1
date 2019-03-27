package com.example.elearning.rest;

import com.example.elearning.entities.Chapitre;
import com.example.elearning.repositories.ChapitreRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("chapitre")
public class chapitreRestController {

    //Actions
    private ChapitreRepository chapitreRepository;

    public chapitreRestController(ChapitreRepository chapitreRepository) {
        this.chapitreRepository = chapitreRepository;
    }

    @GetMapping()
    public List<Chapitre> allChapitres(){
        return chapitreRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Chapitre> findById(@PathVariable("id") int idChapitre)
            throws ResourceNotFoundException {
        Chapitre chapitre = chapitreRepository.findById(idChapitre)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun chapitre trouvé avec : " + idChapitre));
        return ResponseEntity.ok().body(chapitre);
    }

    @PostMapping
    public ResponseEntity<Chapitre> addChapitre(@Valid @RequestBody Chapitre chapitre){
        try {
            chapitreRepository.save(chapitre);
            return new ResponseEntity<Chapitre>(chapitre, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<Chapitre>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chapitre> updateChapitre(@PathVariable("id") int idChapitre, @RequestBody Chapitre chapitreDetails)
            throws ResourceNotFoundException {
        Chapitre chapitre = chapitreRepository.findById(idChapitre)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun chapitre trouvé avec : " + idChapitre));
        chapitre.setDescription(chapitreDetails.getDescription());
        chapitre.setModule(chapitreDetails.getModule());
        chapitre.setIdchapitre(chapitreDetails.getIdchapitre());
        chapitre.setTitre(chapitreDetails.getTitre());
        final Chapitre updatedChapitre = chapitreRepository.save(chapitre);
        return ResponseEntity.ok(updatedChapitre);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteChapitre(@PathVariable("id") int idChapitre) throws Exception{
        Chapitre chapitre = chapitreRepository.findById(idChapitre)
                .orElseThrow(() -> new ResourceNotFoundException("Aucun chapitre trouvé avec : " + idChapitre));
        chapitreRepository.delete(chapitre);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Chapitre supprimé",Boolean.TRUE);
        return response;
    }
}
