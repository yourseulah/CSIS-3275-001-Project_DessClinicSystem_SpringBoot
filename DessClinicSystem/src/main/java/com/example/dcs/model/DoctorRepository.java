package com.example.dcs.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	List<Doctor> findByMajorContainingIgnoreCase(String major);
}
