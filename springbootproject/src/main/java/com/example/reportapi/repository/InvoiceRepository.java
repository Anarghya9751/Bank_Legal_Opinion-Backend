
package com.example.reportapi.repository;

import com.example.reportapi.model.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	
	
	
	//custom queries write here
}

