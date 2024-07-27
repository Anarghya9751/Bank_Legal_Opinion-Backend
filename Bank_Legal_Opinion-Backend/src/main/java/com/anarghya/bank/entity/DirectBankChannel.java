package com.anarghya.bank.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bankchannel")
public class DirectBankChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Integer bankId;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "branch_manager_name")
    private String branchManagerName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(unique = true)
    private String email;

   
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "reference_number")
    private Long referenceNumber;

   
    @OneToMany(mappedBy = "directbank", cascade = CascadeType.ALL)
    private List<BranchEntity> branches;

    @OneToMany(mappedBy = "directbank", cascade = CascadeType.ALL)
    private List<PricingEntity> pricing;
    

    
    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchManagerName() {
        return branchManagerName;
    }

    public void setBranchManagerName(String branchManagerName) {
        this.branchManagerName = branchManagerName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public List<BranchEntity> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchEntity> branches) {
        this.branches = branches;
    }
    public List<PricingEntity> getPricing() {
        return pricing;
   }

    public void setPricing(List<PricingEntity> pricing) {
        this.pricing = pricing;
    }
    
    

	public DirectBankChannel(Integer bankId, String bankName, String branchManagerName, Long phoneNumber, String email,
			LocalDate registrationDate, Long referenceNumber, List<BranchEntity> branches,
			List<PricingEntity> pricing) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.branchManagerName = branchManagerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.registrationDate = registrationDate;
		this.referenceNumber = referenceNumber;
		this.branches = branches;
		this.pricing = pricing;
	}

	public DirectBankChannel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
