package com.lawfirm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "filecreation")
public class FileCreationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fileId;

	@NotBlank(message = "Branch should not be null")
	private String branch;

	@NotBlank(message = "Client Name should not be null")
	@Size(min = 3, max = 50, message = "Client name must contain 3 to 50 characters")
	private String clientName;

	@NotBlank(message = "Phone number cannot be empty")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits long and start with a digit between 6 and 9")
	private String mobile;

	@NotBlank(message = "Address cannot be empty")
	@Size(max = 255, message = "Address cannot be more than 255 characters")
	@Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]+$", message = "Address must contain only letters, numbers, spaces, commas, periods, apostrophes, and hyphens")
	private String address;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String documents;

	@NotBlank(message = "Document name cannot be empty")
	private String documentName;

	@NotBlank(message = "Verified status cannot be empty")
	private String verifiedStatus;

	@ManyToOne
	@JoinColumn(name = "bankId")
	private BankEntity bank;

	@ManyToOne
	@JoinColumn(name = "propertyId")
	private PropertyDetailsEntity property;

	
	
	
	
	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getVerifiedStatus() {
		return verifiedStatus;
	}

	public void setVerifiedStatus(String verifiedStatus) {
		this.verifiedStatus = verifiedStatus;
	}

	public BankEntity getBank() {
		return bank;
	}

	public void setBank(BankEntity bank) {
		this.bank = bank;
	}

	public PropertyDetailsEntity getProperty() {
		return property;
	}

	public void setProperty(PropertyDetailsEntity property) {
		this.property = property;
	}

	public FileCreationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileCreationEntity(Integer fileId, @NotBlank(message = "Branch should not be null") String branch,
			@NotBlank(message = "Client Name should not be null") @Size(min = 3, max = 50, message = "Client name must contain 3 to 50 characters") String clientName,
			@NotBlank(message = "Phone number cannot be empty") @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits long and start with a digit between 6 and 9") String mobile,
			@NotBlank(message = "Address cannot be empty") @Size(max = 255, message = "Address cannot be more than 255 characters") @Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]+$", message = "Address must contain only letters, numbers, spaces, commas, periods, apostrophes, and hyphens") String address,
			String documents, @NotBlank(message = "Document name cannot be empty") String documentName,
			@NotBlank(message = "Verified status cannot be empty") String verifiedStatus, BankEntity bank,
			PropertyDetailsEntity property) {
		super();
		this.fileId = fileId;
		this.branch = branch;
		this.clientName = clientName;
		this.mobile = mobile;
		this.address = address;
		this.documents = documents;
		this.documentName = documentName;
		this.verifiedStatus = verifiedStatus;
		this.bank = bank;
		this.property = property;
	}

}