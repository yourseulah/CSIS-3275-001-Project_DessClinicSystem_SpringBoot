package com.example.dcs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import com.example.dcs.model.Appointment;
import com.example.dcs.model.AppointmentRepository;
import com.example.dcs.model.Doctor;
import com.example.dcs.model.Gender;
import com.example.dcs.model.DoctorRepository;
import com.example.dcs.model.Invoice;
import com.example.dcs.model.Invoice.Status;
import com.example.dcs.model.InvoiceRepository;

@SpringBootApplication
public class DessClinicSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DessClinicSystemApplication.class, args);
	}

	private void loadData(DoctorRepository doctorRepository,AppointmentRepository appointmentRepository, InvoiceRepository invoiceRepository) {
		ArrayList<Doctor> doctors = new ArrayList<>();
		doctorRepository.save(
				new Doctor(LocalDate.of(1989, 8, 29), "Kalie", "Kim", 
						Gender.Female, "physician", 8));
		doctorRepository.save(
				new Doctor(LocalDate.of(1982, 2, 07), "Becky", "Smith", 
						Gender.Female, "gynecologist", 10));
		doctorRepository.save(
				new Doctor(LocalDate.of(1978, 5, 19), "Paul", "Hart", 
						Gender.Male, "ophthalmologist", 15));
		
		doctorRepository.findAll().forEach(System.out::println);	
    
    ArrayList<Invoice> invoices = new ArrayList<>();
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "VISA", 120, Status.Paid, "GCG Canada", 10));
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "AMEX", 40, Status.Pending, "GCG USA", 20));
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "MASTERCARD", 1000, Status.Unknown, "GCG COL", 5));
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "TD", 1900, Status.Unknown, "HAPPY HEALTH", 5));
		
		invoiceRepository.findAll().forEach(System.out::println);
		
		
		// custom - sri: start testing appointment - created only with patient creation
		// need to enter visit date, visit time and quick note only while creating appointment, 
		// rest all will be coming from patient details
		ArrayList<Appointment> appointments = new ArrayList<>();
		appointmentRepository.save(new Appointment("2023-04-10", LocalTime.of(9, 00), "Testing"));
		appointmentRepository.findAll().forEach(System.out::println);
		// custom - sri: end
		
	}
	
	
	@Bean

	ApplicationRunner init(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, InvoiceRepository invoiceRepository) {
		return args -> {
			loadData(doctorRepository,appointmentRepository, invoiceRepository);
		};
	}
	
	
}
