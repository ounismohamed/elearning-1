package com.example.elearning.metier;

import com.example.elearning.entities.Formation;
import com.example.elearning.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional

public class ElearningImpl implements IElearning {
    @Autowired      //injection des dependences
    private FormationRepository formationRepository;

    @Override
    public Optional<Formation> consulterFormation(int idFormation) {
        Optional<Formation> formation=null;
        if (formationRepository.existsById(idFormation)) {

            formation = formationRepository.findById(idFormation);
        }
        if (formation == null) throw new RuntimeException("Formation introuvable");
        return formation;
    }

    @Override
    public Page<Formation> listFormation(int page, int size) {
        return formationRepository.listFormation(PageRequest.of(page,size));
    }

//    @Override
//    public Page<Formation> listFormation(int page, int size) {
//        if (formationRepository.findAll() == null) {
//            throw new RuntimeException("Pas de formations disponibles");
//        }
//        return formationRepository.listFormation(PageRequest.of(page,size));
//    }
}
