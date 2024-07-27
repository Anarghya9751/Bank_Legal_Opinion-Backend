package com.tejaswi.entity;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "filecreation")
public class FileCreationEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fileId;
	private String entity;
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	@NotEmpty(message = "branch should not be null")
	private String branch;
	@NotEmpty(message = "First Name should not be null")
	 @Size(min = 3 , max = 50 , message = "First name contains 3 to 50 characters only")
	private String clientName;
	@NotEmpty(message = "Phone number cannot be empty")
	 @Pattern(regexp = "^[6-9]\\d{9}$", 
	        message = "Phone number must be 10 digits long and start with a digit between 6 and 9")
	private String mobile;
	@NotEmpty(message = "Address cannot be empty")
	 @Size(max = 255, message = "Address cannot be more than 255 characters")
	 @Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]+$", 
	        message = "Address must contain only letters, numbers, spaces, commas, periods, apostrophes, and hyphens")
	private String address;

	@OneToMany(mappedBy = "fileCreation", cascade = CascadeType.ALL)
	private List<PropertyDetailsEntity> properties;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String documents;
	@NotEmpty(message = "Document name cannot be empty")
	private String documentName;
	@NotEmpty(message = "verifiedStatus cannot be empty")
	private String verifiedStatus;

	
	
	
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

	public List<PropertyDetailsEntity> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyDetailsEntity> properties) {
		this.properties = properties;
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

	public FileCreationEntity(Integer fileId, String branch, String clientName, String mobile, String address,
			List<PropertyDetailsEntity> properties, String documents, String documentName, String verifiedStatus) {
		super();
		this.fileId = fileId;
		this.branch = branch;
		this.clientName = clientName;
		this.mobile = mobile;
		this.address = address;
		this.properties = properties;
		this.documents = documents;
		this.documentName = documentName;
		this.verifiedStatus = verifiedStatus;
	}

	public FileCreationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
