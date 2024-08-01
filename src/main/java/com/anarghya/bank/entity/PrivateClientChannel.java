package com.anarghya.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientchannel")
public class PrivateClientChannel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pvtclientid;
	@NotEmpty(message = "this field required")
	@Pattern(regexp = "^[a-zA-z]+$", message = "clientname must contain alphabets only")
	private String clientname;
	@NotEmpty(message = "Address cannot be empty")
	@Size(max = 255, message = "Address cannot be more than 255 characters")
	@Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]+$", message = "Address must contain only letters, numbers, spaces, commas, periods, apostrophes, and hyphens")
	private String address;
	@NotEmpty(message = "Phone number cannot be empty")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits long and start with a digit between 6 and 9")
	private String phnum;
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Email should be valid")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email must be a valid email address")
	@Size(max = 100, message = "Email must be up to 100 characters")
	private String email;
	@NotEmpty(message = "servicetype cannot be empty")
	private String servicetype;
	
	
	

	public Integer getPvtclientid() {
		return pvtclientid;
	}

	public void setPvtclientid(Integer pvtclientid) {
		this.pvtclientid = pvtclientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhnum() {
		return phnum;
	}

	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public PrivateClientChannel(Integer pvtclientid, String clientname, String address, String phnum, String email,
			String servicetype) {
		super();
		this.pvtclientid = pvtclientid;
		this.clientname = clientname;
		this.address = address;
		this.phnum = phnum;
		this.email = email;
		this.servicetype = servicetype;
	}

	public PrivateClientChannel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
