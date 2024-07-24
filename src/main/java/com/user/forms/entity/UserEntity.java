package com.user.forms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="UserForm")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
	//firstName
	@NotEmpty(message = "This field is required")
	@Pattern(regexp ="^[a-zA-z]+$",message = "firstname must contain alphabets only")
   private String  firstName;
	//lastName
	@NotEmpty(message = "This field is required")
	@Pattern(regexp ="^[a-zA-z]+$",message = "lastname must contain alphabets only")
	 private String  lastName;
	
   //mail 
	@NotEmpty(message = "This field is required")
	//@Email(message = "Invalid mail format") not working properly
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "Invalid mail format")
	@Column(name = "mail",unique = true)
   private String  mail;
	//phoneNumber
	@NotNull(message = "Phone number cannot be null")
//	@Pattern(regexp = "^\\d{10}$", message = "Invalid phoneNumber")
   private Long   phoneNumber;
	
   private String address;

   public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public Long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(Long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


public UserEntity(Long id, String firstName, String lastName, String mail, Long phoneNumber, String address,
		String password, String confirmPassword) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.mail = mail;
	this.phoneNumber = phoneNumber;
	this.address = address;
	
}
public UserEntity() {
	super();
	// TODO Auto-generated constructor stub
}

}
