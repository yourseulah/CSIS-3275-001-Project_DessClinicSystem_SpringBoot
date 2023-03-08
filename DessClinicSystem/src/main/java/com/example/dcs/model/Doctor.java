package com.example.dcs.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dId;
	
	@Column(name = "Date of Birth")
	private LocalDate dDoB;
	
	@Column(name = "First Name")
	private String dFName;
	
	@Column(name = "Last Name")
	private String dLName;
	
	@Column(name = "Gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "Specialty")
	private String major;
	
	@Column(name = "Years of Practice")
	private int dYoP;

	//constructors
	public Doctor() {}

	public Doctor(LocalDate dDoB, String dFName, String dLName, Gender gender, String major, int dYoP) {
		this.dDoB = dDoB;
		this.dFName = dFName;
		this.dLName = dLName;
		this.gender = gender;
		this.major = major;
		this.dYoP = dYoP;
	}

	//getters and setters
	public long getdId() {
		return dId;
	}

	public void setdId(long dId) {
		this.dId = dId;
	}

	public LocalDate getdDoB() {
		return dDoB;
	}

	public void setdDoB(LocalDate dDoB) {
		this.dDoB = dDoB;
	}

	public String getdFName() {
		return dFName;
	}

	public void setdFName(String dFName) {
		this.dFName = dFName;
	}

	public String getdLName() {
		return dLName;
	}

	public void setdLName(String dLName) {
		this.dLName = dLName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getdYoP() {
		return dYoP;
	}

	public void setdYoP(int dYoP) {
		this.dYoP = dYoP;
	}	
	

}
