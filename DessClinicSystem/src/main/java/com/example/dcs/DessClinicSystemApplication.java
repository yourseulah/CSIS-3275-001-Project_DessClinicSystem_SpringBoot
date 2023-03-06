package com.example.dcs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import com.example.dcs.model.Doctor;
import com.example.dcs.model.Doctor.Gender;
import com.example.dcs.model.DoctorRepository;
import com.example.dcs.model.Invoice;
import com.example.dcs.model.Invoice.Status;
import com.example.dcs.model.InvoiceRepository;

@SpringBootApplication
public class DessClinicSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DessClinicSystemApplication.class, args);
	}

	private void loadData(DoctorRepository doctorRepository) {
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
	}
	
	
	private void loadData(InvoiceRepository invoiceRepository) {
		ArrayList<Invoice> invoices = new ArrayList<>();
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "VISA", 120, Status.Paid, "GCG Canada", 10));
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "AMEX", 40, Status.Pending, "GCG USA", 20));
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "MASTERCARD", 1000, Status.Unknown, "GCG COL", 5));
		
		invoiceRepository.findAll().forEach(System.out::println);
	}
	
	
	@Bean
	ApplicationRunner init(DoctorRepository doctorRepository, InvoiceRepository invoiceRepository) {
		return args -> {
			loadData(doctorRepository);
			loadData(invoiceRepository);
		};
	}
}
