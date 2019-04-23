package com.example.elearning.repositories;

import com.example.elearning.entities.Formateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormateurRepository extends JpaRepository<Formateur,Integer> {

    @Query("select ff from Formateur ff")
    Page<Formateur> listformateurs(Pageable pageable);

    @Query("select ff from Formateur ff where ff.nom like :mc")
    Page<Formateur> findByDesignationFormateur(@Param("mc") String mc, Pageable pageable);
}
