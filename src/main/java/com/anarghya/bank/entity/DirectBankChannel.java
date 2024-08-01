package com.anarghya.bank.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "bankchannel")
public class DirectBankChannel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id")
	private Integer bankId;

	@Column(name = "bank_name")
	@NotEmpty(message = "bankName cannot be empty")
	@Size(min = 2, max = 100, message = "bankName must be between 2 and 100 characters")
	@Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "bankName must contain only letters, spaces, hyphens, and apostrophes")
	private String bankName;

	@Column(name = "branch_manager_name")
	@NotEmpty(message = "branchManagerName cannot be empty")
	@Size(min = 2, max = 100, message = "branchManagerName must be between 2 and 100 characters")
	@Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "branchManagerName must contain only letters, spaces, hyphens, and apostrophes")
	private String branchManagerName;
	
	@Column(name = "address")
	@NotEmpty(message = "Address cannot be empty")
	private String address;

	@Column(name = "phone_number")
	@NotEmpty(message = "Phone number cannot be empty")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits long and start with a digit between 6 and 9")
	private String phoneNumber;

	@Column(unique = true)
	private String email;

	@Column(name = "registration_date")
	private LocalDate registrationDate;

	@Column(name = "reference_number")
	private Long referenceNumber;

//	@OneToMany(mappedBy = "directbank", cascade = CascadeType.ALL)
//	private List<BranchEntity> branches;
//
//	@OneToMany(mappedBy = "directbank", cascade = CascadeType.ALL)
//	 @JsonIgnore
//	private List<PricingEntity> pricing;

	

	
	
	
	
	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchManagerName() {
		return branchManagerName;
	}

	public void setBranchManagerName(String branchManagerName) {
		this.branchManagerName = branchManagerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Long getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

//	public List<BranchEntity> getBranches() {
//		return branches;
//	}
//
//	public void setBranches(List<BranchEntity> branches) {
//		this.branches = branches;
//	}
//
//	public List<PricingEntity> getPricing() {
//		return pricing;
//	}
//
//	public void setPricing(List<PricingEntity> pricing) {
//		this.pricing = pricing;
//	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public DirectBankChannel(Integer bankId,
			@NotEmpty(message = "bankName cannot be empty") @Size(min = 2, max = 100, message = "bankName must be between 2 and 100 characters") @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "bankName must contain only letters, spaces, hyphens, and apostrophes") String bankName,
			@NotEmpty(message = "branchManagerName cannot be empty") @Size(min = 2, max = 100, message = "branchManagerName must be between 2 and 100 characters") @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "branchManagerName must contain only letters, spaces, hyphens, and apostrophes") String branchManagerName,
			@NotEmpty(message = "Address cannot be empty") String address,
			@NotEmpty(message = "Phone number cannot be empty") @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits long and start with a digit between 6 and 9") String phoneNumber,
			String email, LocalDate registrationDate, Long referenceNumber) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.branchManagerName = branchManagerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.registrationDate = registrationDate;
		this.referenceNumber = referenceNumber;
//		this.branches = branches;
//		this.pricing = pricing;
	}

	public DirectBankChannel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
