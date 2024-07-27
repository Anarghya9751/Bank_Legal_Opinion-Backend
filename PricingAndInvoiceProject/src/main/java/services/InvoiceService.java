package services;

import java.util.List;
import java.util.Optional;

import entities.InvoiceEntity;

public interface InvoiceService {
	
	

	    InvoiceEntity saveInvoice(InvoiceEntity invoice);
	    
	    Optional<InvoiceEntity> getInvoiceById(Long id);
	    
	    List<InvoiceEntity> getAllInvoices();
	    
	    void deleteInvoice(Long id);
	    
	    byte[] generateInvoicePdf(InvoiceEntity invoice);

}
