package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.InvoiceEntity;
import repositories.InvoiceRepository;


	
	@Service
	public class InvoiceServiceImpl implements InvoiceService {

	    @Autowired
	    private InvoiceRepository invoiceRepository;

	    @Override
	    public InvoiceEntity saveInvoice(InvoiceEntity invoice) {
	        return invoiceRepository.save(invoice);
	    }

	    @Override
	    public Optional<InvoiceEntity> getInvoiceById(Long id) {
	        return invoiceRepository.findById(id);
	    }

	    @Override
	    public List<InvoiceEntity> getAllInvoices() {
	        return invoiceRepository.findAll();
	    }

	    @Override
	    public void deleteInvoice(Long id) {
	        invoiceRepository.deleteById(id);
	    }

	    @Override
	    public byte[] generateInvoicePdf(InvoiceEntity invoice) {
	        // Implement PDF generation logic here
	        return null;
	    }
	}
	
	
	
