package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Report;
import com.example.exception.ChannelNotFoundException;
import com.example.exception.InvalidChannelException;
import com.example.repository.ReportRepository;

@Service
public class ReportService {
	
	    @Autowired
	    private ReportRepository reportRepository;

	    public List<Report> getAllReports() {
	        return reportRepository.findAll();
	    }

	    public Report getReportById(Long id) {
	    	Optional<Report> report = reportRepository.findById(id);
	        if (report.isEmpty()) {
	            throw new ChannelNotFoundException("Report not found with id: " + id);
	        }
	        return report.get();
	    }
	    

	    public Report saveReport(Report report) {
	    	if (report.getStatus() == null ){
	            throw new InvalidChannelException("Report status cannot be null or empty.");
	        }
	        return reportRepository.save(report);
	    }

	    public void deleteReport(Long id) {
	    	if (!reportRepository.existsById(id)) {
	            throw new ChannelNotFoundException("Report not found with id: " + id);
	        }
	        reportRepository.deleteById(id)
	;
	    }
	}


