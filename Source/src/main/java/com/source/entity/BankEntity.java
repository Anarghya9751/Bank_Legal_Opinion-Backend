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
@Table(name = "Bank")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Bank name is required")
    private String bankName;

    @NotEmpty(message = "State is required")
    private String state;

    @NotEmpty(message = "City is required")
    private String city;

   @NotEmpty(message = "Branch name is required")
    private String branchName;

    @NotEmpty(message = "BranchId is required")
    private String branchId;

    @NotEmpty(message = "Branch manager name is required")
    private String branchManagerName;

    @Email(message = "Invalid email format")
    private String mailid;

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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchManagerName() {
		return branchManagerName;
	}

	public void setBranchManagerName(String branchManagerName) {
		this.branchManagerName = branchManagerName;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
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

	public BankEntity(Long id, String bankName, String state, String city, String branchName, String branchId,
			String branchManagerName, String mailid, String contactNumber, Date date) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.state = state;
		this.city = city;
		this.branchName = branchName;
		this.branchId = branchId;
		this.branchManagerName = branchManagerName;
		this.mailid = mailid;
		this.contactNumber = contactNumber;
		this.date = date;
	}

	public BankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}