package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Report;
import com.example.repository.ReportRepository;

@Service
public class ReportService {
	 @Autowired
	    private ReportRepository reportRepository;

	    public List<Report> getAllReports() {
	        return reportRepository.findAll();
	    }

	    public Report getReportById(Long id) {
	        return reportRepository.findById(id).orElse(null);
	    }

	    public Report saveReport(Report report) {
	        return reportRepository.save(report);
	    }

	    public void deleteReport(Long id) {
	        reportRepository.deleteById(id);
	    }


}
