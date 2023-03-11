package com.example.dcs.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	List<Patient> findByLastNameContainingIgnoreCase(String lastName);
	List<Patient> findByFirstNameContainingIgnoreCase(String firstName);
	
	Optional<Patient> findByPatientId(String patientId);

}
