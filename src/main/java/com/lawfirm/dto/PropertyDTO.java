package com.lawfirm.dto;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PropertyDTO {

	private Long propertyId;

	@NotBlank(message = "Property Type cannot be empty")
	private String propertyType;

	@NotBlank(message = "Address cannot be empty")
	@Size(max = 255, message = "Address cannot be more than 255 characters")
	@Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]+$", message = "Address must contain only letters, numbers, spaces, commas, periods, apostrophes, and hyphens")
	private String address;

	@NotNull(message = "ExtentInSqYds cannot be empty")
	private Long extentInSqYds;

	@NotNull(message = "Registered Document Type cannot be empty")

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] registeredDocumentType;

	@NotBlank(message = "Last Registered Deed cannot be empty")
	private String lastRegisteredDeed;

	@NotBlank(message = "Name of the Purchaser cannot be empty")
	@Size(min = 2, max = 100, message = "Name of the Purchaser must be between 2 and 100 characters")
	@Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name of the Purchaser must contain only letters, spaces, hyphens, and apostrophes")
	private String nameOfThePurchaser;

	@NotBlank(message = "Name of the Seller cannot be empty")
	@Size(min = 2, max = 100, message = "Name of the Seller must be between 2 and 100 characters")
	@Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name of the Seller must contain only letters, spaces, hyphens, and apostrophes")
	private String nameofTheSeller;

	@NotNull(message = "Registration Date cannot be null")
	@Past(message = "Registration Date must be in the past")
	private LocalDate registrationDate;

	@NotBlank(message = "Sub Registrar Office cannot be empty")
	@Size(min = 2, max = 100, message = "Sub Registrar Office must be between 2 and 100 characters")
	@Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Sub Registrar Office must contain only letters, spaces, hyphens, and apostrophes")
	private String subRegistrarOffice;

	
	
	
	
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

	public String getSubRegistrarOffice() {
		return subRegistrarOffice;
	}

	public void setSubRegistrarOffice(String subRegistrarOffice) {
		this.subRegistrarOffice = subRegistrarOffice;
	}

	public PropertyDTO(Long propertyId, @NotBlank(message = "Property Type cannot be empty") String propertyType,
			@NotBlank(message = "Address cannot be empty") @Size(max = 255, message = "Address cannot be more than 255 characters") @Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]+$", message = "Address must contain only letters, numbers, spaces, commas, periods, apostrophes, and hyphens") String address,
			@NotNull(message = "ExtentInSqYds cannot be empty") Long extentInSqYds,
			@NotNull(message = "Registered Document Type cannot be empty") byte[] registeredDocumentType,
			@NotBlank(message = "Last Registered Deed cannot be empty") String lastRegisteredDeed,
			@NotBlank(message = "Name of the Purchaser cannot be empty") @Size(min = 2, max = 100, message = "Name of the Purchaser must be between 2 and 100 characters") @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name of the Purchaser must contain only letters, spaces, hyphens, and apostrophes") String nameOfThePurchaser,
			@NotBlank(message = "Name of the Seller cannot be empty") @Size(min = 2, max = 100, message = "Name of the Seller must be between 2 and 100 characters") @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name of the Seller must contain only letters, spaces, hyphens, and apostrophes") String nameofTheSeller,
			@NotNull(message = "Registration Date cannot be null") @Past(message = "Registration Date must be in the past") LocalDate registrationDate,
			@NotBlank(message = "Sub Registrar Office cannot be empty") @Size(min = 2, max = 100, message = "Sub Registrar Office must be between 2 and 100 characters") @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Sub Registrar Office must contain only letters, spaces, hyphens, and apostrophes") String subRegistrarOffice) {
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
		this.subRegistrarOffice = subRegistrarOffice;
	}

	public PropertyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}