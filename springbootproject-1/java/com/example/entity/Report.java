package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="report")
public class Report {
	 public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(Long id, ReportType type, ReportStatus status, Channel channel) {
		super();
		this.id = id;
		this.type = type;
		this.status = status;
		this.channel = channel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReportType getType() {
		return type;
	}

	public void setType(ReportType type) {
		this.type = type;
	}

	public ReportStatus getStatus() {
		return status;
	}

	public void setStatus(ReportStatus status) {
		this.status = status;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Enumerated(EnumType.STRING)
	    @NotNull(message ="type is mandatory")
	    private ReportType type;

	    @Enumerated(EnumType.STRING)
	    @NotNull(message ="status is mandatory")
	    private ReportStatus status;	 
	   
	    
	    @JoinColumn(name = "channel_id", nullable=false)
	   @ManyToOne
	    private Channel channel;


}
