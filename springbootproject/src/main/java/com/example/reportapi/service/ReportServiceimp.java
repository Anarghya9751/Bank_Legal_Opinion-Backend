
package com.example.reportapi.service;

import com.example.reportapi.model.ReportDetail;
import com.example.reportapi.repository.ReportDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceimp implements ReportService1 {

    @Autowired
    private ReportDetailRepository reportDetailRepository;

   
	@Override
	public ReportDetail saveReport(ReportDetail report) {
		// TODO Auto-generated method stub
		return reportDetailRepository.save(report);
	}

	@Override
	public ReportDetail getById(Long id) {
	Optional<ReportDetail> Reportget=reportDetailRepository.findById(id);
		return Reportget .orElse(null);
	}

	@Override
	public List<ReportDetail> getAll() {
		// TODO Auto-generated method stub
		return reportDetailRepository.findAll();
	}

	@Override
	public ReportDetail updateReport(Long id, ReportDetail report) {
		Optional<ReportDetail> optionalReportDetail = reportDetailRepository.findById(id);
        if (optionalReportDetail.isPresent()) {
            ReportDetail existingReportDetail = optionalReportDetail.get();
            existingReportDetail.setChannel(report.getChannel());
            existingReportDetail.setFilesProcessed(report.getFilesProcessed());
            existingReportDetail.setRevenue(report.getRevenue());
            return reportDetailRepository.save(existingReportDetail);
        }
        return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		 reportDetailRepository.deleteById(id);
		
	}

	
	
	}

	

	

   


