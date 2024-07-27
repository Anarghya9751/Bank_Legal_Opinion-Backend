package com.anarghya.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "clientchannel")
public class PrivateClientChannel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pvtclientid;
//	@NotEmpty(message="this field required")
//	@Pattern(regexp ="^[a-zA-z]+$",message = "clientname must contain alphabets only")
	private String clientname;
	private String address;
	private Long phnum;
	private String email;
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
	public Long getPhnum() {
		return phnum;
	}
	public void setPhnum(Long phnum) {
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
	public PrivateClientChannel(Integer pvtclientid, String clientname, String address, Long phnum, String email,
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
