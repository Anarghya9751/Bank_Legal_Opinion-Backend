package com.example.reportapi.service;

import java.util.List;

import com.example.reportapi.model.Invoice;


public interface InvoiceService1 {
	public Invoice saveInvoice(Invoice voice);
	public  Invoice getById(Long id);
	public List< Invoice> getAll();
	public  Invoice updateinvoice(Long id,Invoice voice);
	public void deleteById(Long id);

}
