package com.example.elearning.metier;

import com.example.elearning.dao.FormationRepository;
import com.example.elearning.entities.Apprenant;
import com.example.elearning.entities.Formateur;
import com.example.elearning.entities.Formation;
import com.example.elearning.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ILearningImpl implements ILearning {
    @Autowired
    private FormationRepository formationRepository;
    @Override
    public Formation consulterFormation(int idFormation) {
        return null;
    }

    @Override
    public Module consulterModule(int idModule) {
        return null;
    }

    @Override
    public Formateur consulterFormateur(int idFormateur) {
        return null;
    }

    @Override
    public Apprenant consulterApprenant(int idApprenant) {
        return null;
    }
}
