package com.example.elearning.repositories;

import com.example.elearning.entities.Formateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormateurRepository extends JpaRepository<Formateur,Integer> {

    @Query("select ff from Formateur ff")
    Page<Formateur> listformateurs(Pageable pageable);

    @Query("select ff from Formateur ff where ff.nom like :mc")
    Page<Formateur> findByDesignationFormateur(@Param("mc") String mc, Pageable pageable);

    /*@Modifying(clearAutomatically = true)
    @Query("update Formateur ff set ff.nom=:nom,ff.email=:email,ff.anciennete=:anciennte,ff.domaineExpertise=:domaine,ff.identifiant=:identif,ff.motdepasse=:motpass where ff.id=:id")
    Formateur updateFormateur(@Param("nom")String nom,@Param("email")String email,@Param("anciennete")String anciennete,@Param("domaine")String domaine,@Param("identif")String identif,@Param("motpass")String motpass,@Param("id")int id);*/
}
