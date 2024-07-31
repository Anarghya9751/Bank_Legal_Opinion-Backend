package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Report;
import com.example.exception.ChannelNotFoundException;
import com.example.exception.InvalidChannelException;
import com.example.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {
	@Autowired
    private ReportService reportService;

    @GetMapping("/getall")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Report> getReportById(@PathVariable Long id) {
        //return reportService.getReportById(id);
    	try {
            Report report = reportService.getReportById(id);
            return ResponseEntity.ok(report);
        } catch (ChannelNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity <Report> createReport(@RequestBody Report report) {
        //return reportService.saveReport(report);
    	 try {
             Report createdReport = reportService.saveReport(report);
             return ResponseEntity.ok(createdReport);
         } catch (InvalidChannelException e) {
             return ResponseEntity.badRequest().body(null);
         }
    }

    @PutMapping("/{id}")
    public ResponseEntity <Report> updateReport(@PathVariable Long id, @RequestBody Report report) {
        //report.setId(id)
;
        //return reportService.saveReport(report);
try {
    Report existingReport = reportService.getReportById(id);
    report.setId(id);
    Report updatedReport = reportService.saveReport(report);
    return ResponseEntity.ok(updatedReport);
} catch (InvalidChannelException e) {
    return ResponseEntity.notFound().build();
} catch (ChannelNotFoundException e) {
    return ResponseEntity.badRequest().body(null);
}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReport(@PathVariable Long id) {
       // reportService.deleteReport(id);
    	try {
            reportService.deleteReport(id);
            return ResponseEntity.noContent().build();
        } catch (InvalidChannelException e) {
            return ResponseEntity.notFound().build();
        }
        
    }
}



