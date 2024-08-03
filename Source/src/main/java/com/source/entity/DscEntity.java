package com.source.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Dsc")
public class DscEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    private String nameofthedsc;

    @NotEmpty(message = "State is required")
    private String state;

    @NotEmpty(message = "City is required")
    private String city;

    @NotEmpty(message = "Area is required")
    private String area;

    @NotEmpty(message = "Authorized person name is required")
    private String authorizedPersonName;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String contactNumber;
    
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
    private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameofthedsc() {
		return nameofthedsc;
	}

	public void setNameofthedsc(String nameofthedsc) {
		this.nameofthedsc = nameofthedsc;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAuthorizedPersonName() {
		return authorizedPersonName;
	}

	public void setAuthorizedPersonName(String authorizedPersonName) {
		this.authorizedPersonName = authorizedPersonName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DscEntity(Long id, String nameofthedsc, String state, String city, String area, String authorizedPersonName,
			String email, String contactNumber, Date date) {
		super();
		this.id = id;
		this.nameofthedsc = nameofthedsc;
		this.state = state;
		this.city = city;
		this.area = area;
		this.authorizedPersonName = authorizedPersonName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.date = date;
	}

	public DscEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}