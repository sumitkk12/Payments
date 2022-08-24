package com.capstone.payments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_details")
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="billsequenceid")
	private int billSequenceId;
	@Column(name="accountno")
	private int accountNo;
	@Column(name="description")
	private String description;
	
	
	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentDetails(int id, int billSequenceId, int accountNo, String description) {
		super();
		this.id = id;
		this.billSequenceId = billSequenceId;
		this.accountNo = accountNo;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBillSequenceId() {
		return billSequenceId;
	}
	public void setBillSequenceId(int billSequenceId) {
		this.billSequenceId = billSequenceId;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PaymentDetails [id=" + id + ", billSequenceId=" + billSequenceId + ", accountNo=" + accountNo
				+ ", description=" + description + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
