package com.example.elearning.metier;

import com.example.elearning.entities.Formation;
import com.example.elearning.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Optional<Formation> formation=formationRepository.findById(idFormation);
        if (formation == null) throw new RuntimeException("Formation introuvable");
        return formation;
    }
}
