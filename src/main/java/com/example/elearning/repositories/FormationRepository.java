package com.example.elearning.repositories;

import com.example.elearning.entities.Formation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FormationRepository extends JpaRepository<Formation,Integer> {

    @Query("select f from Formation f")
    Page<Formation> listFormation(Pageable pageable);

    @Query("select f from Formation f where f.nomformation like :mc")
    Page<Formation> findByDesignationContains(@Param("mc") String mc, Pageable pageable);
}
