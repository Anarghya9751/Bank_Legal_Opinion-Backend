package com.anarghya.price.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;

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
	@NotNull(message = "caseFee cannot be empty ")
	private Long caseFee;

	@Column(name = "notice_fee")
	@NotNull(message = "noticeFee cannot be empty")
	private Long noticeFee;
	
	@Column(name="gst")
	@DecimalMax(value = "8.0", inclusive = true)
	private Long gst;

	public Integer getPriceId() {
		return priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public Long getOpinionFee() {
		return opinionFee;
	}

	public void setOpinionFee(Long opinionFee) {
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

	public Long getGst() {
		return gst;
	}

	public void setGst(Long gst) {
		this.gst = gst;
	}

	public PricingEntity(Integer priceId, Long opinionFee, @NotNull(message = "caseFee cannot be empty ") Long caseFee,
			@NotNull(message = "noticeFee cannot be empty") Long noticeFee,
			@DecimalMax(value = "8.0", inclusive = true) Long gst) {
		super();
		this.priceId = priceId;
		this.opinionFee = opinionFee;
		this.caseFee = caseFee;
		this.noticeFee = noticeFee;
		this.gst = gst;
	}

	public PricingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}