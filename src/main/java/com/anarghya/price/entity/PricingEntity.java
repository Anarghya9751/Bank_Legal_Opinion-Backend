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
	@NotNull(message = "caseFee cannot be empty ")
	private Double opinionFee;

	@Column(name = "case_fee")
	@NotNull(message = "caseFee cannot be empty ")
	private Double caseFee;

	@Column(name = "notice_fee")
	@NotNull(message = "noticeFee cannot be empty")
	private Double noticeFee;
	
	@Column(name="gst")
	@DecimalMax(value = "10.0", inclusive = true)
	@NotNull(message = "GST cannot be empty")
	private Double gst;

	

	public Integer getPriceId() {
		return priceId;
	}



	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}



	public Double getOpinionFee() {
		return opinionFee;
	}



	public void setOpinionFee(Double opinionFee) {
		this.opinionFee = opinionFee;
	}



	public Double getCaseFee() {
		return caseFee;
	}



	public void setCaseFee(Double caseFee) {
		this.caseFee = caseFee;
	}



	public Double getNoticeFee() {
		return noticeFee;
	}



	public void setNoticeFee(Double noticeFee) {
		this.noticeFee = noticeFee;
	}



	public Double getGst() {
		return gst;
	}



	public void setGst(Double gst) {
		this.gst = gst;
	}



	public PricingEntity(Integer priceId, @NotNull(message = "caseFee cannot be empty ") Double opinionFee,
			@NotNull(message = "caseFee cannot be empty ") Double caseFee,
			@NotNull(message = "noticeFee cannot be empty") Double noticeFee,
			@DecimalMax(value = "8.0", inclusive = true) Double gst) {
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