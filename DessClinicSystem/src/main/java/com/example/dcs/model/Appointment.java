package com.example.dcs.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.dcs.model.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
//@Table(name = "appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appt_id")
	private long appointmentId;
	
	//@ManyToOne(fetch = FetchType.EAGER, optional = false)
	//@JoinColumn(name = "patient_id", nullable = false)
	//@JsonIgnore
	//@JsonProperty("patient")
	//private Patient patient;
	
	
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "fk_patient_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_patient_id")
	private Patient patient;
	
	@Column(name = "visit_date")
	private String visitDate;
	
	@Column(name = "visit_time")
	private String visitTime;
	
	@Column(name = "mobile")
	private String mobileNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "quick_note")
	private String quickNote;
	
	@Column(name = "doctor_transcript")
	private String doctorTranscript;
	
	@Column(name = "payment_status")
	private int paymentStatus; // 1 - paid, 0 - unpaid
	
	@Column(name = "amount")
	private double amount;
	
	//@Column(name = "patient_id")
	//private long patientId;
	
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "invoice_id", referencedColumnName = "id")
	private Invoice invoice;

	
	private long doctorId;
	
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public Appointment() {}
	

	public Appointment(String visitDate, String visitTime, String quickNote) {
		super();
		this.visitDate = visitDate;
		this.visitTime = visitTime;
		this.quickNote = quickNote;
		this.paymentStatus = 0; // not paid
		this.amount = 0; // no charge
	}
	
	public Appointment(String visitDate, String visitTime, String quickNote, Patient patient)
	{
		this.visitDate = visitDate;
		this.visitTime = visitTime;
		this.quickNote = quickNote;
		this.paymentStatus = 0; // not paid
		this.amount = 0; // no charge
		this.patient = patient;
		patient.getAppointments().add(this);
	}


	public long getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}


	public String getVisitDate() {
		return visitDate;
	}


	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}


	public String getVisitTime() {
		return visitTime;
	}


	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getQuickNote() {
		return quickNote;
	}


	public void setQuickNote(String quickNote) {
		this.quickNote = quickNote;
	}


	public String getDoctorTranscript() {
		return doctorTranscript;
	}


	public void setDoctorTranscript(String doctorTranscript) {
		this.doctorTranscript = doctorTranscript;
	}


	public int getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	



}
