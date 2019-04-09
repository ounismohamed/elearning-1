package com.example.elearning.repositories;

import com.example.elearning.entities.Formation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FormationRepository extends JpaRepository<Formation,Integer> {

    @Query("select f from Formation f")
    Page<Formation> listFormation(Pageable pageable);

}
