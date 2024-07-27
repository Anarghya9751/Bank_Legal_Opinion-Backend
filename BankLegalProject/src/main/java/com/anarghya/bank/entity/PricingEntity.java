//package com.anarghya.bank.entity;
//
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "pricing")
//public class PricingEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer priceId;
//    
//    private Integer opinionId;
//    private Integer caseFee;    // Use Double instead of double for compatibility with JPA
//    private Integer noticeFee;  // Use Double instead of double for compatibility with JPA
//    
//    @ManyToOne()
//    @JoinColumn(name = "bank_id")
//    private DirectBankChannel directbank;
//
//	public Integer getPriceId() {
//		return priceId;
//	}
//
//	public void setPriceId(Integer priceId) {
//		this.priceId = priceId;
//	}
//
//	public Integer getOpinionId() {
//		return opinionId;
//	}
//
//	public void setOpinionId(Integer opinionId) {
//		this.opinionId = opinionId;
//	}
//
//	public Integer getCaseFee() {
//		return caseFee;
//	}
//
//	public void setCaseFee(Integer caseFee) {
//		this.caseFee = caseFee;
//	}
//
//	public Integer getNoticeFee() {
//		return noticeFee;
//	}
//
//	public void setNoticeFee(Integer noticeFee) {
//		this.noticeFee = noticeFee;
//	}
//
//	public DirectBankChannel getDirectbank() {
//		return directbank;
//	}
//
//	public void setDirectbank(DirectBankChannel directbank) {
//		this.directbank = directbank;
//	}
//
//	public PricingEntity(Integer priceId, Integer opinionId, Integer caseFee, Integer noticeFee,
//			DirectBankChannel directbank) {
//		super();
//		this.priceId = priceId;
//		this.opinionId = opinionId;
//		this.caseFee = caseFee;
//		this.noticeFee = noticeFee;
//		this.directbank = directbank;
//	}
//
//	public PricingEntity() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	
//    
//    
//}
package com.anarghya.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "pricing")
public class PricingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Integer priceId;

    @Column(name = "opinion_Fee")
    private Long opinionFee;

    @Column(name = "case_fee")
    private Long caseFee;

    @Column(name = "notice_fee")
    private Long noticeFee;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bank_id")
    private DirectBankChannel directbank;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dsc_id")
    private DSCChannel dsc;

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Long getOpinionFee() {
        return opinionFee;
    }

    public void setOpinionId(Long opinionFee) {
        this.opinionFee = opinionFee;
    }

    public Long getCaseFee() {
        return caseFee;
    }

    public void setCaseFee(Long caseFee) {
        this.caseFee = caseFee;
    }

    public Long getNoticeFee() {
        return noticeFee;
    }

    public void setNoticeFee(Long noticeFee) {
        this.noticeFee = noticeFee;
    }

    public DirectBankChannel getDirectbank() {
        return directbank;
    }

    public void setDirectbank(DirectBankChannel directbank) {
        this.directbank = directbank;
    }

	public DSCChannel getDsc() {
		return dsc;
	}

	public void setDsc(DSCChannel dsc) {
		this.dsc = dsc;
	}

	public PricingEntity(Integer priceId, Long opinionFee, Long caseFee, Long noticeFee,
			DirectBankChannel directbank, DSCChannel dsc) {
		super();
		this.priceId = priceId;
		this.opinionFee = opinionFee;
		this.caseFee = caseFee;
		this.noticeFee = noticeFee;
		this.directbank = directbank;
		this.dsc = dsc;
	}

	public PricingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
