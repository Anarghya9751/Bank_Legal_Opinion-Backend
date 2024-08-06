package com.clientinfo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "clientInfo")
public class ClientInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name Must Not Be Empty Or Null")
	private String name;
	
	@NotBlank(message = "FatherName Must Not Be Empty Or Null")
	private String fatherName;
	
	@NotBlank(message = "MotherName Must Not Be Empty Or Null")
	private String motherName;
	
	@NotBlank(message = "Gender Must Not Be Empty Or Null")
	private String gender;
	
	@NotBlank(message = "MarkOfIdentity Must Not Be Empty Or Null")
	private String markOfIdentity;
	

//	@NotBlank(message = "MobileNumber Must Not Be Empty Or Null")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "MobileNumber must be 10 digits long and start with a digit between 6 and 9")
	private String mobileNumber;
	
	@NotBlank(message = "Email Must Not Be Empty Or Null")
	private String email;
	
	@NotBlank(message = "Address Must Not Be Empty Or Null")
	private String address;
	
	  @Column(name = "date_of_birth") // Specify the column name if needed
	    private LocalDate dateOfBirth;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] adharcard ;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] panCard ;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] passport ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarkOfIdentity() {
		return markOfIdentity;
	}

	public void setMarkOfIdentity(String markOfIdentity) {
		this.markOfIdentity = markOfIdentity;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
      
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public byte[] getAdharcard() {
		return adharcard;
	}

	public void setAdharcard(byte[] adharcard) {
		this.adharcard = adharcard;
	}

	public byte[] getPanCard() {
		return panCard;
	}

	public void setPanCard(byte[] panCard) {
		this.panCard = panCard;
	}

	public byte[] getPassport() {
		return passport;
	}

	public void setPassport(byte[] passport) {
		this.passport = passport;
	}

	public ClientInfoEntity(Long id, @NotBlank(message = "Name Must Not Be Empty Or Null") String name,
			@NotBlank(message = "FatherName Must Not Be Empty Or Null") String fatherName,
			@NotBlank(message = "MotherName Must Not Be Empty Or Null") String motherName,
			@NotBlank(message = "Gender Must Not Be Empty Or Null") String gender,
			@NotBlank(message = "MarkOfIdentity Must Not Be Empty Or Null") String markOfIdentity,
			@Pattern(regexp = "^[6-9]\\d{9}$", message = "MobileNumber must be 10 digits long and start with a digit between 6 and 9") String mobileNumber,
			@NotBlank(message = "Email Must Not Be Empty Or Null") String email,
			@NotBlank(message = "Address Must Not Be Empty Or Null") String address, LocalDate dateOfBirth,
			byte[] adharcard, byte[] panCard, byte[] passport) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.gender = gender;
		this.markOfIdentity = markOfIdentity;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.adharcard = adharcard;
		this.panCard = panCard;
		this.passport = passport;
	}

	public ClientInfoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	}
