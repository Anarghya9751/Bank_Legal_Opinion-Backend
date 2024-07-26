
package com.example.reportapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reports")
public class ReportDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String channel;
    private Integer filesProcessed;
    private Integer revenue;
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Integer getFilesProcessed() {
		return filesProcessed;
	}
	public void setFilesProcessed(Integer filesProcessed) {
		this.filesProcessed = filesProcessed;
	}
	public Integer getRevenue() {
		return revenue;
	}
	public void setRevenue(Integer revenue) {
		this.revenue = revenue;
	}
	public ReportDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportDetail(Long id, String channel, Integer filesProcessed, Integer revenue) {
		super();
		this.id = id;
		this.channel = channel;
		this.filesProcessed = filesProcessed;
		this.revenue = revenue;
	}
	
}

