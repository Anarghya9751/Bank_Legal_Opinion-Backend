package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.InvoiceEntity;
import services.InvoiceService;

	
	@RestController
	@RequestMapping("/api/invoices")
	
	public class InvoiceController {

	    @Autowired
	    private InvoiceService invoiceService;

	    @PostMapping("/save")
	    public InvoiceEntity createInvoice(@RequestBody InvoiceEntity invoice) {
	        return invoiceService.saveInvoice(invoice);
	    }

	    @GetMapping("/getAll")
	    public List<InvoiceEntity> getAllInvoices() {
	        return invoiceService.getAllInvoices();
	    }

	    @GetMapping("/{id}")
	    public Optional<InvoiceEntity> getInvoiceById(@PathVariable Long id) {
	        return invoiceService.getInvoiceById(id);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteInvoice(@PathVariable Long id) {
	        invoiceService.deleteInvoice(id);
	    }

	   
}
	
	
	
	
	
	
	
	
