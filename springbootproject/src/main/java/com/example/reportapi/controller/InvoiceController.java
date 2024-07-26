package com.example.reportapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reportapi.model.Invoice;
import com.example.reportapi.service.InvoiceServiceimp;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
	 @Autowired
	    private InvoiceServiceimp invoiceserviceimp;
	 
	 @PostMapping("/save")
	    public ResponseEntity<Invoice> createReportDetail(@RequestBody Invoice voice) {
	        Invoice createdReportDetail = invoiceserviceimp.saveInvoice(voice);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdReportDetail);
	    }
	 @GetMapping("/{id}")
	    public ResponseEntity<Invoice> getById(@PathVariable Long id) {
	        Invoice invoice = invoiceserviceimp.getById(id);
	        if (invoice != null) {
	            return ResponseEntity.ok(invoice);
	        }
	        return ResponseEntity.notFound().build();
	    }
	 @GetMapping("/getall")
	 public List<Invoice> getinvoices() {
			return invoiceserviceimp.getAll();
		}
	 @PutMapping("/{id}")
	    public ResponseEntity<Invoice> updateinvoiceDetail(
	            @PathVariable Long id,
	            @RequestBody Invoice voice
	    ) {
	        Invoice invoiceDetail = invoiceserviceimp.updateinvoice(id, voice);
	        if (invoiceDetail!= null) {
	            return ResponseEntity.ok(invoiceDetail);
	        }
	        return ResponseEntity.notFound().build();
	    }
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
	        invoiceserviceimp.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	 
	

}
