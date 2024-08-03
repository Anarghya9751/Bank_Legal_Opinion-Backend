package com.anarghya.price.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dscchannel")
public class DSCChannel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dscid;
	@NotEmpty(message = "dscname cannot be empty")
	@Size(min = 2, max = 100, message = "dscname must be between 2 and 100 characters")
	@Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "dscname must contain only letters, spaces, hyphens, and apostrophes")
	private String dscname;
	@NotEmpty(message = "directorname cannot be empty")
	@Size(min = 2, max = 100, message = "directorname must be between 2 and 100 characters")
	@Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "directorname must contain only letters, spaces, hyphens, and apostrophes")
	private String directorname;
	@NotEmpty(message = "Phone number cannot be empty")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits long and start with a digit between 6 and 9")
	private String phnum;
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Email should be valid")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email must be a valid email address")
	@Size(max = 100, message = "Email must be up to 100 characters")
	private String email;
	
	@NotEmpty(message = "Address cannot be empty")
	private String address;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] mou;

	@ManyToOne
	   @JoinColumn(name = "price_id")
	    private PricingEntity pricing;

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

	public byte[] getMou() {
		return mou;
	}

	public void setMou(byte[] mou) {
		this.mou = mou;
	}

	public PricingEntity getPricing() {
		return pricing;
	}

	public void setPricing(PricingEntity pricing) {
		this.pricing = pricing;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public DSCChannel(Integer dscid,
			@NotEmpty(message = "dscname cannot be empty") @Size(min = 2, max = 100, message = "dscname must be between 2 and 100 characters") @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "dscname must contain only letters, spaces, hyphens, and apostrophes") String dscname,
			@NotEmpty(message = "directorname cannot be empty") @Size(min = 2, max = 100, message = "directorname must be between 2 and 100 characters") @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "directorname must contain only letters, spaces, hyphens, and apostrophes") String directorname,
			@NotEmpty(message = "Phone number cannot be empty") @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits long and start with a digit between 6 and 9") String phnum,
			@NotEmpty(message = "Email cannot be empty") @Email(message = "Email should be valid") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email must be a valid email address") @Size(max = 100, message = "Email must be up to 100 characters") String email,
			@NotEmpty(message = "Address cannot be empty") String address, byte[] mou, PricingEntity pricing) {
		super();
		this.dscid = dscid;
		this.dscname = dscname;
		this.directorname = directorname;
		this.phnum = phnum;
		this.email = email;
		this.address = address;
		this.mou = mou;
		this.pricing = pricing;
	}

	public DSCChannel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
