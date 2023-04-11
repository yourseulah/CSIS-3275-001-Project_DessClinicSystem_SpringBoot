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
	
	boolean debug = false;
	
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
				if(debug) System.out.println("OK-a0");				

				
				System.out.println("Patient ID: " + appt.getPatient().getId());
				
				Patient pat = appt.getPatient();
				if(debug) System.out.println("OK-a1");				
				Appointment newApp = new Appointment(appt.getVisitDate(), appt.getVisitTime(), appt.getQuickNote());
				if(debug) System.out.println("OK-a2");				
				
				newApp.setPatient(pat);
				if(debug) System.out.println("OK-a3");				
				
//				Optional<Patient> pt = patientRepository.findById(appt.getPatient().getId());
//				System.out.println("OK-a4");				

				Appointment newAppt = appointmentRepository.save(newApp);
				appointmentRepository.save(newApp);
				
				if(debug) System.out.println("OK-a5");				
				return new ResponseEntity<>(newAppt, HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		// Deleting a new appointment
		@DeleteMapping("/appointments/{id}")
		public ResponseEntity<HttpStatus> deleteAppointment(
				@PathVariable("id") long id) {
			try {
				
				Appointment appt;
				Patient pat;
				
				Optional<Appointment> apt = appointmentRepository.findById(id);
				if(apt.isPresent()) {
					appt = apt.get();
					pat = appt.getPatient();
					pat.removeAppointment(appt);
					if(debug) System.out.println(appt.getPatient().getId());
				}
				
				appointmentRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch(Exception e) {
				return new ResponseEntity<>(null, 
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		

	

}
