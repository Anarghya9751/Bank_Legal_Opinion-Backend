package com.example.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="channel")
public class Channel {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Report> reports;

	    private Double revenueGenerated;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<Report> getReports() {
			return reports;
		}

		public void setReports(Set<Report> reports) {
			this.reports = reports;
		}

		public Double getRevenueGenerated() {
			return revenueGenerated;
		}

		public void setRevenueGenerated(Double revenueGenerated) {
			this.revenueGenerated = revenueGenerated;
		}

		public Channel(Long id, String name, Set<Report> reports, Double revenueGenerated) {
			super();
			this.id = id;
			this.name = name;
			this.reports = reports;
			this.revenueGenerated = revenueGenerated;
		}

		public Channel() {
			super();
			// TODO Auto-generated constructor stub
		} 
}
