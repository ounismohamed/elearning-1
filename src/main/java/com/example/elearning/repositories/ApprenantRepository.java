package com.example.elearning.repositories;

import com.example.elearning.entities.Apprenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApprenantRepository extends JpaRepository<Apprenant,Integer> {
    @Query("select aa from Apprenant aa")
    Page<Apprenant> listapprenants(Pageable pageable);

    @Query("select aa from Apprenant aa where aa.nom like :mc")
    Page<Apprenant> findByDesignationApprenant(@Param("mc") String mc, Pageable pageable);
}
