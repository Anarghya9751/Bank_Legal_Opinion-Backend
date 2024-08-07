package com.source.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Bank")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "bankName is required")
    @Pattern(regexp ="^[a-zA-z]+$",message = "bankName must contain alphabets only")
    private String bankName;

    @NotEmpty(message = "state is required")
    @Pattern(regexp ="^[a-zA-z]+$",message = "state must contain alphabets only")
    private String state;

    @NotEmpty(message = "city is required")
    @Pattern(regexp ="^[a-zA-z]+$",message = "city must contain alphabets only")
    private String city;

   @NotEmpty(message = "branchName is required")
   @Pattern(regexp ="^[a-zA-z]+$",message = "branchName must contain alphabets only")
    private String branchName;

//    @NotEmpty(message = "branchId is required")
//    private String branchId;

    @NotEmpty(message = "branchmanagername is required")
    @Pattern(regexp ="^[a-zA-z]+$",message = "branchManagerName must contain alphabets only")
    private String branchManagerName;

    @Email(message = "Invalid email format")
  	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.(com|in)$", message = "email must be a valid Gmail address (gmail.com or gmail.in)")
  	@Column(name = "mail",unique = true)
    private String mailid;
    
    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits only")
    private String contactNumber;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
    private Date date;
    
    @ManyToOne
	@JoinColumn(name = "branch_id")
	private BranchEntity branch;

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

//	public String getBranchId() {
//		return branchId;
//	}
//
//	public void setBranchId(String branchId) {
//		this.branchId = branchId;
//	}

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

	

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}
	
	

	
	public BankEntity(Long id,
			@NotEmpty(message = "bankName is required") @Pattern(regexp = "^[a-zA-z]+$", message = "bankName must contain alphabets only") String bankName,
			@NotEmpty(message = "state is required") @Pattern(regexp = "^[a-zA-z]+$", message = "state must contain alphabets only") String state,
			@NotEmpty(message = "city is required") @Pattern(regexp = "^[a-zA-z]+$", message = "city must contain alphabets only") String city,
			@NotEmpty(message = "branchName is required") @Pattern(regexp = "^[a-zA-z]+$", message = "branchName must contain alphabets only") String branchName,
			@NotEmpty(message = "branchmanagername is required") @Pattern(regexp = "^[a-zA-z]+$", message = "branchManagerName must contain alphabets only") String branchManagerName,
			@Email(message = "Invalid email format") @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.(com|in)$", message = "email must be a valid Gmail address (gmail.com or gmail.in)") String mailid,
			@NotNull(message = "Phone number cannot be null") @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits only") String contactNumber,
			Date date, BranchEntity branch) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.state = state;
		this.city = city;
		this.branchName = branchName;
		this.branchManagerName = branchManagerName;
		this.mailid = mailid;
		this.contactNumber = contactNumber;
		this.date = date;
		this.branch = branch;
	}

	public BankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}