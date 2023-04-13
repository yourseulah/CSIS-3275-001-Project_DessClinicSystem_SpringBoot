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
@Table(name = "appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appt_id")
	private long id;	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "patient_id", nullable = true)
	private Patient patient;
	
	@Column(name = "visit_date")
	private LocalDate visitDate;
	
	@Column(name = "visit_time")
	private LocalTime visitTime;
	
	@Column(name = "quick_note")
	private String quickNote;
	
//	@Column(name = "doctor_transcript")
//	private String doctorTranscript;
	
	@Column(name = "payment_status")
	private int paymentStatus; // 1 - paid, 0 - unpaid
	
	@Column(name = "amount")
	private double amount;
	
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "invoice_id", referencedColumnName = "id")
	private Invoice invoice;
	
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "doctor_id", referencedColumnName = "dId")
	private Doctor doctor;

	public Appointment() {}

	public Appointment(LocalDate visitDate, LocalTime visitTime, String quickNote) {
		super();
		this.visitDate = visitDate;
		this.visitTime = visitTime;
		this.quickNote = quickNote;
		this.paymentStatus = 0; // not paid
		this.amount = 0; // no charge
	}

	public Appointment(LocalDate visitDate, LocalTime visitTime, String quickNote, Patient patient)
	{
		super();
		this.visitDate = visitDate;
		this.visitTime = visitTime;
		this.quickNote = quickNote;
		this.paymentStatus = 0; // not paid
		this.amount = 0; // no charge
		this.patient = patient;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public long getAppointmentId() {
		return id;
	}

	public void setAppointmentId(long appointmentId) {
		this.id = appointmentId;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public LocalTime getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(LocalTime visitTime) {
		this.visitTime = visitTime;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getQuickNote() {
		return quickNote;
	}

	public void setQuickNote(String quickNote) {
		this.quickNote = quickNote;
	}

	//public String getDoctorTranscript() {
	//	return doctorTranscript;
	//}

	//public void setDoctorTranscript(String doctorTranscript) {
	//	this.doctorTranscript = doctorTranscript;
	//}

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
