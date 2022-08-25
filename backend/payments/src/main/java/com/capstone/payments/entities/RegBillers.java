package com.capstone.payments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regbillers")
public class RegBillers {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bllerseqid")
	private int billerSeqId;
	@Column(name="accountno")
	private int accountNo;
	@Column(name="billercode")
	private String billerCode;
	@Column(name="consumerno")
	private int consumerNo;
	@Column(name = "autopay")
	private int autoPay;
	@Column(name = "autopaylimit")
	private int autopayLimit;
	public int getBillerSeqId() {
		return billerSeqId;
	}
	public void setBillerSeqId(int billerSeqId) {
		this.billerSeqId = billerSeqId;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
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
	public int getAutoPay() {
		return autoPay;
	}
	public void setAutoPay(int autoPay) {
		this.autoPay = autoPay;
	}
	public int getAutopayLimit() {
		return autopayLimit;
	}
	public void setAutopayLimit(int autopayLimit) {
		this.autopayLimit = autopayLimit;
	}
	public RegBillers(int billerSeqId, int accountNo, String billerCode, int consumerNo, int autoPay,
			int autopayLimit) {
		super();
		this.billerSeqId = billerSeqId;
		this.accountNo = accountNo;
		this.billerCode = billerCode;
		this.consumerNo = consumerNo;
		this.autoPay = autoPay;
		this.autopayLimit = autopayLimit;
	}
	public RegBillers() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RegBillers [billerSeqId=" + billerSeqId + ", accountNo=" + accountNo + ", billerCode=" + billerCode
				+ ", consumerNo=" + consumerNo + ", autoPay=" + autoPay + ", autopayLimit=" + autopayLimit + "]";
	}
	
	
	
	
}
