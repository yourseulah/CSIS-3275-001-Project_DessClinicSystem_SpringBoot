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

import com.example.dcs.model.Invoice;
import com.example.dcs.model.InvoiceRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InvoiceController {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@GetMapping("/invoices")
	public ResponseEntity<List<Invoice>> getAllInvoices(){
		List<Invoice> invoices = new ArrayList<Invoice>();
		try {		
			invoiceRepository.findAll().forEach(invoices::add);
	   		return new ResponseEntity<>(invoices, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/invoices/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") long id) {
		try {
			Optional<Invoice> invoice = invoiceRepository.findById(id);
			
			if(invoice.isPresent()) {
				return new ResponseEntity<>(invoice.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PutMapping("/invoices/{id}")
	public ResponseEntity<Invoice> updateInvoice(
			@PathVariable("id")long id, @RequestBody Invoice invoice) {
		
		Optional<Invoice> invoiceFound = invoiceRepository.findById(id);
		
		if(invoiceFound.isPresent()) {
			Invoice newInvoice = invoiceFound.get();
			newInvoice.setAmount(invoice.getAmount());
			newInvoice.setInsuranceCompany(invoice.getInsuranceCompany());
			newInvoice.setMethod(invoice.getMethod());
			newInvoice.setPaymentDate(invoice.getPaymentDate());
			newInvoice.setStatus(invoice.getStatus());
			newInvoice.setYearsOfPractice(invoice.getYearsOfPractice());
			
			return new ResponseEntity<>(invoiceRepository.save(newInvoice), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	
	
}
