package com.capstone.payments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "billsequenceid")
	private int billSeqId;
	@Column(name="billercode")
	private String billerCode;
	@Column(name = "consumerno")
	private int consumerNo; 
	@Column(name = "amount")
	private int amount;
	@Column(name = "duedate")
	private String dueDate;
	@Column(name = "status")
	private String status;
	
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(int billSeqId, String billerCode, int consumerNo, int amount, String dueDate, String status) {
		super();
		this.billSeqId = billSeqId;
		this.billerCode = billerCode;
		this.consumerNo = consumerNo;
		this.amount = amount;
		this.dueDate = dueDate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bill [billSeqId=" + billSeqId + ", billerCode=" + billerCode + ", consumerNo=" + consumerNo
				+ ", amount=" + amount + ", dueDate=" + dueDate + ", status=" + status + "]";
	}
	public int getBillSeqId() {
		return billSeqId;
	}
	public void setBillSeqId(int billSeqId) {
		this.billSeqId = billSeqId;
	}
	public String getBillerCode() {
		return billerCode;
	}
	public void setBillerCode(String billerCode) {
		this.billerCode = billerCode;
	}
	public int getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
