package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Report {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Enumerated(EnumType.STRING)
	    private ReportType type;

	    @Enumerated(EnumType.STRING)
	    private ReportStatus status;

	    @ManyToOne
	    @JoinColumn(name = "channel_id")
	    private Channel channel;

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

		public Report(Long id, ReportType type, ReportStatus status, Channel channel) {
			super();
			this.id = id;
			this.type = type;
			this.status = status;
			this.channel = channel;
		}

		public Report() {
			super();
			// TODO Auto-generated constructor stub
		}


}
