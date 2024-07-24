package com.anarghya.bank.entity;

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

@Entity
@Table(name = "filecreation")
public class FileCreationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fileId;

	private String branch;
	private String clientName;
	private Long mobile;
	private String address;

	@OneToMany(mappedBy = "fileCreation", cascade = CascadeType.ALL)
	private List<PropertyDetailsEntity> properties;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String documents;

	private String documentName;
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

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
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

	public FileCreationEntity(Integer fileId, String branch, String clientName, Long mobile, String address,
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
