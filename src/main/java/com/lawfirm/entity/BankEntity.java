package com.lawfirm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "bank")
public class BankEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankId;

	@NotBlank(message = "Bank Name Must Not Be Empty Or Null")
	private String bankName;

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BankEntity(Long bankId, @NotBlank(message = "Bank Name Must Not Be Empty Or Null") String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}

	public BankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}