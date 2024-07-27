package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Report;
import com.example.service.ReportService;
@RestController
@RequestMapping("/reports")
public class ReportController {
	 @Autowired
	    private ReportService reportService;

	    @GetMapping
	    public List<Report> getAllReports() {
	        return reportService.getAllReports();
	    }

	    @GetMapping("/{id}")
	    public Report getReportById(@PathVariable Long id) {
	        return reportService.getReportById(id);
	    }

	    @PostMapping
	    public Report createReport(@RequestBody Report report) {
	        return reportService.saveReport(report);
	    }

	    @PutMapping("/{id}")
	    public Report updateReport(@PathVariable Long id, @RequestBody Report report) {
	        report.setId(id);
	        return reportService.saveReport(report);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteReport(@PathVariable Long id) {
	        reportService.deleteReport(id);
	    }

}
