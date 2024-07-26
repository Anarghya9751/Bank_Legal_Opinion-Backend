package com.example.reportapi.service;

import java.util.List;

import com.example.reportapi.model.ReportDetail;

public interface ReportService1 {
	public ReportDetail saveReport(ReportDetail report);
	public ReportDetail getById(Long id);
	public List<ReportDetail> getAll();
	public ReportDetail updateReport(Long id,ReportDetail report);
	public void deleteById(Long id);
	
}
