package com.anarghya.bank.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "property")
public class PropertyDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long propertyId;
	private String propertyType;
	private String address;
	
	private Long extentInSqYds;
	
	private byte[] registeredDocumentType;
	
	private String lastRegisteredDeed;
	private String nameOfThePurchaser;
	private String nameofTheSeller;
	private LocalDate registrationDate;
	private String subRegistarOffice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id")
	private FileCreationEntity fileCreation;

	
	
	
	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getExtentInSqYds() {
		return extentInSqYds;
	}

	public void setExtentInSqYds(Long extentInSqYds) {
		this.extentInSqYds = extentInSqYds;
	}

	public byte[] getRegisteredDocumentType() {
		return registeredDocumentType;
	}

	public void setRegisteredDocumentType(byte[] registeredDocumentType) {
		this.registeredDocumentType = registeredDocumentType;
	}

	public String getLastRegisteredDeed() {
		return lastRegisteredDeed;
	}

	public void setLastRegisteredDeed(String lastRegisteredDeed) {
		this.lastRegisteredDeed = lastRegisteredDeed;
	}

	public String getNameOfThePurchaser() {
		return nameOfThePurchaser;
	}

	public void setNameOfThePurchaser(String nameOfThePurchaser) {
		this.nameOfThePurchaser = nameOfThePurchaser;
	}

	public String getNameofTheSeller() {
		return nameofTheSeller;
	}

	public void setNameofTheSeller(String nameofTheSeller) {
		this.nameofTheSeller = nameofTheSeller;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getSubRegistarOffice() {
		return subRegistarOffice;
	}

	public void setSubRegistarOffice(String subRegistarOffice) {
		this.subRegistarOffice = subRegistarOffice;
	}

	public FileCreationEntity getFileCreation() {
		return fileCreation;
	}

	public void setFileCreation(FileCreationEntity fileCreation) {
		this.fileCreation = fileCreation;
	}

	public PropertyDetailsEntity(Long propertyId, String propertyType, String address, Long extentInSqYds,
			byte[] registeredDocumentType, String lastRegisteredDeed, String nameOfThePurchaser, String nameofTheSeller,
			LocalDate registrationDate, String subRegistarOffice, FileCreationEntity fileCreation) {
		super();
		this.propertyId = propertyId;
		this.propertyType = propertyType;
		this.address = address;
		this.extentInSqYds = extentInSqYds;
		this.registeredDocumentType = registeredDocumentType;
		this.lastRegisteredDeed = lastRegisteredDeed;
		this.nameOfThePurchaser = nameOfThePurchaser;
		this.nameofTheSeller = nameofTheSeller;
		this.registrationDate = registrationDate;
		this.subRegistarOffice = subRegistarOffice;
		this.fileCreation = fileCreation;
	}

	public PropertyDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}