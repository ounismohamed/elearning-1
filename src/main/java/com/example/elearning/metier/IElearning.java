package com.example.elearning.metier;

import com.example.elearning.entities.Formation;

import java.util.Optional;

public interface IElearning {
     Optional<Formation> consulterFormation(int idFormation);

}
