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
	
	@Override
	public String toString() {
		return "PaymentDetails [id=" + id + ", billSequenceId=" + billSequenceId + ", accountNo=" + accountNo + "]";
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
	
	
}
