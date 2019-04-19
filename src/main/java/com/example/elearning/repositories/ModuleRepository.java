package com.example.elearning.repositories;

import com.example.elearning.entities.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends JpaRepository <Module,Integer> {

    /*@Query("select m from Module m")
    Page<Module> listModule(Pageable pageable);*/
}
