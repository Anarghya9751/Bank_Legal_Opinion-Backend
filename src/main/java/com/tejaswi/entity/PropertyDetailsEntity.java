package com.tejaswi.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "property")
public class PropertyDetailsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long propertyId;
	@NotEmpty(message = "Property Type cannot be empty")
	private String propertyType;
	@NotEmpty(message = "Address cannot be empty")
	 @Size(max = 255, message = "Address cannot be more than 255 characters")
	 @Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]+$", 
	        message = "Address must contain only letters, numbers, spaces, commas, periods, apostrophes, and hyphens")
	private String address;
	@NotNull(message = "ExtentInSqYds cannot be empty")
	private Long extentInSqYds;
	@NotBlank(message = "registeredDocumentType cannot be empty")
	private byte[] registeredDocumentType;
	@NotEmpty(message = "lastRegisteredDeed cannot be empty")
	private String lastRegisteredDeed;
	@NotEmpty(message = "nameOfThePurchaser cannot be empty")
    @Size(min = 2, max = 100, message = "nameOfThePurchaser must be between 2 and 100 characters")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "nameOfThePurchaser must contain only letters, spaces, hyphens, and apostrophes")
	private String nameOfThePurchaser;
	@NotEmpty(message = "nameofTheSeller cannot be empty")
    @Size(min = 2, max = 100, message = "nameofTheSeller must be between 2 and 100 characters")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "nameofTheSeller must contain only letters, spaces, hyphens, and apostrophes")
	private String nameofTheSeller;
	 @NotNull(message = "registrationDate cannot be null")
	 @Past(message = "registrationDate must be in the past")
	private LocalDate registrationDate;
	 @NotEmpty(message = "subRegistarOffice cannot be empty")
	    @Size(min = 2, max = 100, message = "subRegistarOffice must be between 2 and 100 characters")
	    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "subRegistarOffice must contain only letters, spaces, hyphens, and apostrophes")
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
