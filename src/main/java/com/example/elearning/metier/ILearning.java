package com.example.elearning.metier;


import com.example.elearning.entities.Apprenant;
import com.example.elearning.entities.Formateur;
import com.example.elearning.entities.Formation;
import com.example.elearning.entities.Module;

public interface ILearning {
    Formation consulterFormation(int idFormation);
    Module consulterModule(int idModule);
    Formateur consulterFormateur(int idFormateur);
    Apprenant consulterApprenant(int idApprenant);

}
