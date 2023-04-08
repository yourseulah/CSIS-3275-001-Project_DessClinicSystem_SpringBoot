package com.example.dcs.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "patientId")
	private String patientId;
	
	@Column(name="firstName")
	private String firstName;
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	@Column(name="lastName")
	private String lastName;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="mobile")
	private String mobile;

	@Column(name="email")
	private String email;

	@Column(name="address")
	private String address;

	@Column(name="zipCode")
	private String zipCode;
	
	@Column(name="surgery")
	private String surgery;

	@Column(name="allergies")
	private String allergies;

	@Column(name="geneticDisease")
	private String geneticDisease;
	
	
	// custom: relationship
	
//	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Appointment appointment;
//	private Set<Appointment> appointments = new HashSet<>();
	
	
	// one to many and one to one

	public Appointment getAppointments() {
		return appointment;
	}
	
//	public Set<Appointment> getAppointments() {
//		return appointments;
//	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
//	public void setAppointments(Set<Appointment> appointments) {
//		this.appointments = appointments;
//	}

	//constructors
	public Patient() {}
	
	public Patient(String firstName, String lastName, Gender gender, LocalDate dob, String mobile, String email, 
			String address, String zipCode, String surgery, String allergies, String geneticDisease, String patientId){
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
		this.dob=dob;
		this.mobile=mobile;
		this.email=email;
		this.address=address;
		this.zipCode=zipCode;
		this.surgery=surgery;
		this.allergies=allergies;
		this.geneticDisease=geneticDisease;
		this.patientId = patientId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSurgery() {
		return surgery;
	}

	public void setSurgery(String surgery) {
		this.surgery = surgery;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getGeneticDisease() {
		return geneticDisease;
	}

	public void setGeneticDisease(String geneticDisease) {
		this.geneticDisease = geneticDisease;
	}
	
}
