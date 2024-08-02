package com.example.propertyapi.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Property type is mandatory")
    private PropertyType propertyType; // House, Land, Building, Flat

    @Positive(message = "Extent must be positive")
    private Double extentInSqYds;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @Enumerated(EnumType.STRING)
    private Boundary east;

    @Enumerated(EnumType.STRING)
    private Boundary west;

    @Enumerated(EnumType.STRING)
    private Boundary north;

    @Enumerated(EnumType.STRING)
    private Boundary south;

    @NotBlank(message = "Current owner name is mandatory")
    private String currentOwnerName;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Document type is mandatory")
    private DocumentType documentType; // Sale deed, Gift deed, etc.

    @NotBlank(message = "Document number is mandatory")
    private String documentNumber;

    @NotNull(message = "Year of purchase is mandatory")
    private Integer yearOfPurchase;

    @NotBlank(message = "Seller name is mandatory")
    private String sellerName;

    @NotNull(message = "Registration date is mandatory")
    private LocalDate registrationDate;

    @NotBlank(message = "Registrar or Sub-Registrar office is mandatory")
    private String registrarOffice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public Double getExtentInSqYds() {
		return extentInSqYds;
	}

	public void setExtentInSqYds(Double extentInSqYds) {
		this.extentInSqYds = extentInSqYds;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boundary getEast() {
		return east;
	}

	public void setEast(Boundary east) {
		this.east = east;
	}

	public Boundary getWest() {
		return west;
	}

	public void setWest(Boundary west) {
		this.west = west;
	}

	public Boundary getNorth() {
		return north;
	}

	public void setNorth(Boundary north) {
		this.north = north;
	}

	public Boundary getSouth() {
		return south;
	}

	public void setSouth(Boundary south) {
		this.south = south;
	}

	public String getCurrentOwnerName() {
		return currentOwnerName;
	}

	public void setCurrentOwnerName(String currentOwnerName) {
		this.currentOwnerName = currentOwnerName;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Integer getYearOfPurchase() {
		return yearOfPurchase;
	}

	public void setYearOfPurchase(Integer yearOfPurchase) {
		this.yearOfPurchase = yearOfPurchase;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRegistrarOffice() {
		return registrarOffice;
	}

	public void setRegistrarOffice(String registrarOffice) {
		this.registrarOffice = registrarOffice;
	}

	public Property(Long id, PropertyType propertyType,
			@Positive(message = "Extent must be positive") Double extentInSqYds,
			@NotBlank(message = "Address is mandatory") String address, Boundary east, Boundary west, Boundary north,
			Boundary south, @NotBlank(message = "Current owner name is mandatory") String currentOwnerName,
			DocumentType documentType, @NotBlank(message = "Document number is mandatory") String documentNumber,
			@NotNull(message = "Year of purchase is mandatory") Integer yearOfPurchase,
			@NotBlank(message = "Seller name is mandatory") String sellerName, LocalDate registrationDate,
			@NotBlank(message = "Registrar or Sub-Registrar office is mandatory") String registrarOffice) {
		super();
		this.id = id;
		this.propertyType = propertyType;
		this.extentInSqYds = extentInSqYds;
		this.address = address;
		this.east = east;
		this.west = west;
		this.north = north;
		this.south = south;
		this.currentOwnerName = currentOwnerName;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.yearOfPurchase = yearOfPurchase;
		this.sellerName = sellerName;
		this.registrationDate = registrationDate;
		this.registrarOffice = registrarOffice;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
