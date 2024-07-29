
package com.example.reportapi.controller;

import com.example.reportapi.model.ReportDetail;
import com.example.reportapi.service.ReportServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportControllerssss {

    @Autowired
    private ReportServiceimp reportService;

   

    @PostMapping("/save")
    public ResponseEntity<ReportDetail> createReportDetail(@RequestBody ReportDetail reportDetail) {
        ReportDetail createdReportDetail = reportService.saveReport(reportDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReportDetail);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<ReportDetail> getById(@PathVariable Long id) {
        ReportDetail reportDetail = reportService.getById(id);
        if (reportDetail != null) {
            return ResponseEntity.ok(reportDetail);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/getAll")
    
    public List<ReportDetail> getreport() {
		// TODO Auto-generated method stub
		return reportService.getAll();
	}
    
    @PutMapping("/{id}")
    public ResponseEntity<ReportDetail> updateReportDetail(
            @PathVariable Long id,
            @RequestBody ReportDetail reportDetail
    ) {
        ReportDetail updatedReportDetail = reportService.updateReport(id, reportDetail);
        if (updatedReportDetail!= null) {
            return ResponseEntity.ok(updatedReportDetail);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}

