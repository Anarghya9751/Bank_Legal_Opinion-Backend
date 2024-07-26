package com.example.reportapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reportapi.model.Invoice;
import com.example.reportapi.repository.InvoiceRepository;

@Service
public class InvoiceServiceimp implements InvoiceService1 {
	 @Autowired
	    private InvoiceRepository invoiceRepository;

	
	 public Invoice saveInvoice(Invoice voice) {
		
		return  invoiceRepository.save(voice) ;
	}

	public Invoice getById(Long id) {
		Optional<Invoice> getinvoiceid=invoiceRepository.findById(id);
		return getinvoiceid.orElse(null);
	}

	public List<Invoice> getAll()
	{
		
		// TODO Auto-generated method stub
		return invoiceRepository.findAll();
	}

	


	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		invoiceRepository.deleteById(id);
	}

	@Override
	public Invoice updateinvoice(Long id, Invoice voice) {
		// TODO Auto-generated method stub
		return null;
	}

}
