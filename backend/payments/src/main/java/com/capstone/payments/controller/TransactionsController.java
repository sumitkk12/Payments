package com.capstone.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.payments.entities.Accounts;
import com.capstone.payments.entities.Bill;
import com.capstone.payments.entities.PaymentDetails;
import com.capstone.payments.repository.AccountsRepository;
import com.capstone.payments.repository.BillRepository;

@RestController
public class TransactionsController {
	@Autowired
	BillRepository billRepository;
	@Autowired
	AccountsRepository accRepository;
	
	@PostMapping("/paymentManual")
	public String paymentManual(@RequestBody PaymentDetails pd) {
		System.out.println(pd);
		Bill bill = billRepository.findBybillSeqId(pd.getBillSequenceId());
		Accounts acc = accRepository.findByaccountNo(pd.getAccountNo());
		
		if(bill.getAmount() > acc.getCurrentBal()) {
			return "Insufficient Balance";
		}
		else {
			acc.setCurrentBal(acc.getCurrentBal()-bill.getAmount());
			bill.setStatus("PAID");
			accRepository.save(acc);
			billRepository.save(bill);
		}
		return "Paymentdone";
	}
}
