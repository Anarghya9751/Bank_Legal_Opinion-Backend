package com.source.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "branches")
public class BranchEntity {



	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "branch_id")
	    private Integer branchId;
	 
		@NotEmpty(message = "First Name should not be null")
		 @Size(min = 3 , max = 50 , message = "First name contains 3 to 50 characters only")
		private String branchName;
		
		@NotEmpty(message = "Phone number cannot be empty")
//		 @Pattern(regexp = "^[6-9]\\d{9}$", 
//		        message = "Phone number must be 10 digits long and start with a digit between 6 and 9")
		private String ifscCode;
		
		@NotEmpty(message = "Address cannot be empty")
		 @Size(max = 255, message = "Address cannot be more than 255 characters")
		 @Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]+$", 
		        message = "Address must contain only letters, numbers, spaces, commas, periods, apostrophes, and hyphens")
		private String address;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "bank_id")
//    private DirectBankChannel directbank;

	public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	

	public BranchEntity(Integer branchId,
			@NotEmpty(message = "First Name should not be null") @Size(min = 3, max = 50, message = "First name contains 3 to 50 characters only") String branchName,
			@NotEmpty(message = "Phone number cannot be empty") String ifscCode,
			@NotEmpty(message = "Address cannot be empty") @Size(max = 255, message = "Address cannot be more than 255 characters") @Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]+$", message = "Address must contain only letters, numbers, spaces, commas, periods, apostrophes, and hyphens") String address) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.address = address;
	}

	public BranchEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
  
}
