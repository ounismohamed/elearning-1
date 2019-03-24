package com.example.elearning.dao;

import com.example.elearning.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository <Module,Integer> {
}
