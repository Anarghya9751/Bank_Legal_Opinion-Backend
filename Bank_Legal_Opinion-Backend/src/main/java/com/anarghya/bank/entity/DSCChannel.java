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
@Table(name= "dscchannel")
public class DSCChannel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dscid;
	
	private String dscname;
	private String directorname;
	private Long phnum;
	private String email;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] mou;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PricingEntity> pricing;	

	public Integer getDscid() {
		return dscid;
	}

	public void setDscid(Integer dscid) {
		this.dscid = dscid;
	}

	public String getDscname() {
		return dscname;
	}

	public void setDscname(String dscname) {
		this.dscname = dscname;
	}

	public String getDirectorname() {
		return directorname;
	}

	public void setDirectorname(String directorname) {
		this.directorname = directorname;
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

	public byte[] getMou() {
		return mou;
	}

	public void setMou(byte[] mou) {
		this.mou = mou;
	}

	public List<PricingEntity> getPricing() {
		return pricing;
	}

	public void setPricing(List<PricingEntity> pricing) {
		this.pricing = pricing;
	}

	public DSCChannel(Integer dscid, String dscname, String directorname, Long phnum, String email, byte[] mou,
			List<PricingEntity> pricing) {
		super();
		this.dscid = dscid;
		this.dscname = dscname;
		this.directorname = directorname;
		this.phnum = phnum;
		this.email = email;
		this.mou = mou;
		this.pricing = pricing;
	}

	public DSCChannel() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
}
