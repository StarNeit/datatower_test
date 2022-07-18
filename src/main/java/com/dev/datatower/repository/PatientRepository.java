package com.dev.datatower.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.datatower.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByGenderOrderByLastNameAsc(Integer gender, Pageable pageable);
}
