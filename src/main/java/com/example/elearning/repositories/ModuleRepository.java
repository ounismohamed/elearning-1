package com.example.elearning.repositories;

import com.example.elearning.entities.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends JpaRepository <Module,Integer> {

    @Query(value = "select m from Module m inner join m.formation")
    Page<Module> listModule(Pageable pageable);

    @Query(value = "select m from Module m where m.id=:x")
    Page<Module> pageModule(@Param("x") int idFormation, Pageable pageable);
}
