package com.example.dcs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dcs.model.Appointment;
import com.example.dcs.model.AppointmentRepository;



@CrossOrigin(origins = "http://localhost:8081") // used for vue
@RestController
@RequestMapping("/api")
public class AppointmentController {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	
	// get all appointments (need to implement with patient ID, and doctorID)
		@GetMapping("/appointments")
		public ResponseEntity<List<Appointment>> getAllAppointments(@RequestParam(required=false) String visitDate){
			try {
				List<Appointment> appointments = new ArrayList<Appointment>();
				
				if(visitDate == null)
				{
					appointmentRepository.findAll().forEach(appointments::add);
				}
				else {
					appointmentRepository.findByVisitDate(visitDate).forEach(appointments::add);	
				}
				if(appointments.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
				}
				return new ResponseEntity<>(appointments, HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(null, 
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		// runs when we see a create appointment booking page
		// @GetMapping("/appointments/{aId}")
		
		
		// To create a new appointment with the doctor -- -- (student - registers - course) - (patient-appointment-invoice)
		/*@PostMapping("/registerappointment/{pid}")
		public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appt ) {
			try {
				//Optional<Patient> patientData = patientRepository.findById(pid);
				//Optional<Section> sec = sectionRepository.findById(appt.getSection().getId());
				//Appointment newAppt = appointmentRepository.save(new Registration(st.get(), sec.get()));
				return new ResponseEntity<>(newAppt, HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}*/
	

}
