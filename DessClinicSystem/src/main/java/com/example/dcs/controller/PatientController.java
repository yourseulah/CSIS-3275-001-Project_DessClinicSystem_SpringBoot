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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dcs.model.Patient;
import com.example.dcs.model.PatientRepository;

@CrossOrigin(origins = "http://localhost:8081") //This is for Vue.js
@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepo;
	
	//To create a new patient record
	@PostMapping("/patients")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
		try {
			//public Patient(String firstName, String lastName, PGender gender, String dob, 
			//String mobile, String email, String address, String zipCode, String surgery, 
			//String allergies, String geneticDisease){
			Patient newPatient = new Patient(patient.getFirstName(),patient.getLastName(),
					patient.getGender(), patient.getDob(), patient.getMobile(), patient.getEmail(),
					patient.getAddress(), patient.getZipCode(), patient.getSurgery(),
					patient.getAllergies(), patient.getGeneticDisease(), patient.getPatientId());
			patientRepo.save(newPatient);
			return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//To get all patient records by using a search string (optional)
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>>getAllPatients(@RequestParam(required=false)String searchStr){
		try {
			List<Patient> patients=new ArrayList<Patient>();
			if(searchStr==null) {
				patientRepo.findAll().forEach(patients::add);
			}else {
				//searching both first name and last time since we do not know search string is about first/last name
				patientRepo.findByLastNameContainingIgnoreCase(searchStr).forEach(patients::add);
				patientRepo.findByFirstNameContainingIgnoreCase(searchStr).forEach(patients::add);
			}
			if(patients.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(patients, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//To get a patient record by id
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id){
		Optional<Patient> patientData = patientRepo.findById(id);
		if(patientData.isPresent()) {
			return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//update a patient
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, 
			@RequestBody Patient patient){
		Optional<Patient> patientData = patientRepo.findById(id);
		if(patientData.isPresent()) {
			
			Patient _patient=patientData.get();
			
			_patient.setFirstName(patient.getFirstName());
			_patient.setLastName(patient.getLastName());
			_patient.setGender(patient.getGender());
			_patient.setDob(patient.getDob());
			_patient.setMobile(patient.getMobile());
			_patient.setEmail(patient.getEmail());
			_patient.setAddress(patient.getAddress());
			_patient.setZipCode(patient.getZipCode());
			_patient.setSurgery(patient.getSurgery());
			_patient.setAllergies(patient.getAllergies());
			_patient.setGeneticDisease(patient.getGeneticDisease());

			return new ResponseEntity<>(patientRepo.save(_patient), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//To delete a patient
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<HttpStatus> deletePatient(
			@PathVariable("id") long id) {
		try {
			patientRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//I believe there shouldn't be a delete all patients end point
}


















