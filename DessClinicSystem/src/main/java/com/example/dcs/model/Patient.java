package com.example.dcs.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="firstName")
	private String firstName;
	
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

	public Patient(String firstName, String lastName, Gender gender, LocalDate dob, String mobile, String email, String address, String zipCode, String surgery, String allergies, String geneticDisease){
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
		this.dob=dob;
		this.email=email;
		this.address=address;
		this.zipCode=zipCode;
		this.surgery=surgery;
		this.allergies=allergies;
		this.geneticDisease=geneticDisease;
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