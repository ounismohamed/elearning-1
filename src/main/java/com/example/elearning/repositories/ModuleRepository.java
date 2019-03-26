package com.example.elearning.repositories;

import com.example.elearning.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository <Module,Integer> {
}
