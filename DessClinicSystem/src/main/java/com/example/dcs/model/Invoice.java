package com.example.dcs.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {
	
	public enum Status {
	    Paid,
	    Pending,
	    Unknown
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    @OneToOne(mappedBy = "invoice")
    private Appointment appointment;
	
	@Column(name = "appointment_id")
	private long appointmentID;
	
	@Column(name = "payment_date")
	private LocalDate paymentDate;
	
	@Column(name = "method")
	private String method;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
		
	@Column(name = "insurance_company")
	private String insuranceCompany;
		

	public Invoice() {

	}


	public Invoice(LocalDate paymentDate, String method, double amount, Status status,
			String insuranceCompany) {
		super();
		this.paymentDate = paymentDate;
		this.method = method;
		this.amount = amount;
		this.status = status;
		this.insuranceCompany = insuranceCompany;
	}


	public long getId() {
		return id;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

}
