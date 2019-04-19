package com.example.elearning.metier;

import com.example.elearning.entities.Formation;
import com.example.elearning.entities.Module;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IElearning {
     Optional<Formation> consulterFormation(int idFormation);
     Page<Formation> listFormation(int page, int size);
     Page<Module> listModule(int page, int size);
}
