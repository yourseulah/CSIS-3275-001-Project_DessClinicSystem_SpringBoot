package com.example.dcs.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	// can fetch appointments with appointment visit Date and patient iD
	
	//Optional<Appointment> findByAppointmentId(String Id);
	
	List<Appointment> findByVisitDate(String visitDate);
	
	

}
