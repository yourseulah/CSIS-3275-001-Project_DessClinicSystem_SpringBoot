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

import com.example.dcs.model.Doctor;
import com.example.dcs.model.DoctorRepository;

@CrossOrigin(origins = "http://localhost:8081") // used for vue
@RestController
@RequestMapping("/api")
public class DoctorController {

	@Autowired
	DoctorRepository doctorRepository;
	
	//To get all doctors, supporting search with major
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> getAllDoctors(
			@RequestParam(required = false) String major){
		try {
			List<Doctor> doctors = new ArrayList<Doctor>();
			if (major == null) {
				doctorRepository.findAll().forEach(doctors::add);
			} else if(major != null){
				doctorRepository.findByMajorContainingIgnoreCase(major).forEach(doctors::add);
			}
			
			if(doctors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); //Error 204
			}
			return new ResponseEntity<>(doctors, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//To get a doctor by id
	@GetMapping("/doctors/{dId}")
	public ResponseEntity<Doctor> getDoctorById(
			@PathVariable("dId") long dId) {
		Optional<Doctor> courseData = doctorRepository.findById(dId);
		
		if(courseData.isPresent()) {
			return new ResponseEntity<>(courseData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//To Create a new doctor record
	@PostMapping("/doctors")
	public ResponseEntity<Doctor> createDoctor(
			@RequestBody Doctor doctor) {
		try {
			Doctor _doctor = doctorRepository.save(new 
					Doctor(doctor.getdDoB(), doctor.getdFName(), doctor.getdLName(),
							doctor.getGender(), doctor.getMajor(), doctor.getdYoP()));
			return new ResponseEntity<>(_doctor, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//To update a doctor
	@PutMapping("/doctors/{dId}")
	public ResponseEntity<Doctor> updateDoctor(
			@PathVariable("dId")long dId, @RequestBody Doctor doctor) {
		
		Optional<Doctor> doctorData = doctorRepository.findById(dId);
		
		if(doctorData.isPresent()) {
			Doctor _doctor = doctorData.get();
			_doctor.setdDoB(doctor.getdDoB());
			_doctor.setdFName(doctor.getdFName());
			_doctor.setdLName(doctor.getdLName());
			_doctor.setGender(doctor.getGender());
			_doctor.setMajor(doctor.getMajor());
			_doctor.setdYoP(doctor.getdYoP());
			return new ResponseEntity<>(
					doctorRepository.save(_doctor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//To delete a course
	@DeleteMapping("/doctors/{dId}")
	public ResponseEntity<HttpStatus> deleteDoctor(
			@PathVariable("dId") long dId) {
		try {
			doctorRepository.deleteById(dId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(null, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//To delete all doctors' records
	@DeleteMapping("/doctors")
	public ResponseEntity<HttpStatus> deleteAllDoctors() {
		try {
			doctorRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(null, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
