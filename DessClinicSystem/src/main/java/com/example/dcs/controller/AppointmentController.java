package com.example.dcs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dcs.model.Appointment;
import com.example.dcs.model.AppointmentRepository;
import com.example.dcs.model.Patient;
import com.example.dcs.model.PatientRepository;



@CrossOrigin(origins = "http://localhost:8081") // used for vue
@RestController
@RequestMapping("/api")
public class AppointmentController {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	
	// patient booking appointment
	@Autowired
	PatientRepository patientRepository;
	
	
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
		
		
		
		// creating a new appointment
		@PostMapping("/appointments")
		public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appt ) {
			try {
				System.out.println(appt);
//				System.out.println("Patient ID: " + appt.getPatient().getId());
				System.out.println("Patient ID: " + appt.getPatientId());
//				Optional<Patient> pt = patientRepository.findById(appt.getPatient().getId());
//				Appointment newAppt = appointmentRepository.save(new Appointment(appt.getVisitDate(),
//						appt.getVisitTime(), appt.getQuickNote(), appt.getPatient()));
				Appointment newAppt = appointmentRepository.save(new Appointment(appt.getVisitDate(),
						appt.getVisitTime(), appt.getQuickNote(), appt.getPatientId(), appt.getPatientName()));
				return new ResponseEntity<>(newAppt, HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		// Deleting a new appointment
		

		@DeleteMapping("/appointments/{aId}")
		public ResponseEntity<HttpStatus> deleteDoctor(
				@PathVariable("aId") long aId) {
			try {
				appointmentRepository.deleteById(aId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch(Exception e) {
				return new ResponseEntity<>(null, 
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		


}
