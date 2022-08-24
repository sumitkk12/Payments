package com.capstone.payments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sequenceid")
	private int sequenceID;
	@Column(name="transactionsref")
	private int transactionsRef;
	@Column(name="date_time")
	private String date_time;
	@Column(name="amount")
	private int amount;
	@Column(name="transactiontype")
	private int transactionType;
	@Column(name="description")
	private int description;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="billrefno")
	private int billRefNo;
	
	public Transactions(int sequenceID, int transactionsRef, String date_time, int amount, int transactionType,
			int description, int billRefNo) {
		super();
		this.sequenceID = sequenceID;
		this.transactionsRef = transactionsRef;
		this.date_time = date_time;
		this.amount = amount;
		this.transactionType = transactionType;
		this.description = description;
		this.billRefNo = billRefNo;
	}

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AccountTransaction [sequenceID=" + sequenceID + ", transactionsRef=" + transactionsRef + ", date_time="
				+ date_time + ", amount=" + amount + ", transactionType=" + transactionType + ", description="
				+ description + ", billRefNo=" + billRefNo + "]";
	}

	public int getSequenceID() {
		return sequenceID;
	}

	public void setSequenceID(int sequenceID) {
		this.sequenceID = sequenceID;
	}

	public int getTransactionsRef() {
		return transactionsRef;
	}

	public void setTransactionsRef(int transactionsRef) {
		this.transactionsRef = transactionsRef;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	public int getBillRefNo() {
		return billRefNo;
	}

	public void setBillRefNo(int billRefNo) {
		this.billRefNo = billRefNo;
	}
	
	
	
}
