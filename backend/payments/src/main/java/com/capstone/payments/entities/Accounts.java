package com.capstone.payments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sequenceid")
	private int sequenceId;
	@Column(name="accountno")
	private int accountNo;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="currentbal")
	private int currentBal;
	
	public Accounts(int sequenceId, int accountNo, String name, String email, int currentBal) {
		super();
		this.sequenceId = sequenceId;
		this.accountNo = accountNo;
		this.name = name;
		this.email = email;
		this.currentBal = currentBal;
	}
	
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "accounts [sequenceId=" + sequenceId + ", accountNo=" + accountNo + ", name=" + name + ", email=" + email
				+ ", currentBal=" + currentBal + "]";
	}

	public int getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(int sequenceId) {
		this.sequenceId = sequenceId;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCurrentBal() {
		return currentBal;
	}

	public void setCurrentBal(int currentBal) {
		this.currentBal = currentBal;
	}
	
	
}
