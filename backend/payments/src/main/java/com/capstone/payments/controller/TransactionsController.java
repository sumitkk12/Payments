package com.capstone.payments.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import javax.naming.InsufficientResourcesException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.payments.entities.Accounts;
import com.capstone.payments.entities.Bill;
import com.capstone.payments.entities.PaymentDetails;
import com.capstone.payments.entities.Transaction;
import com.capstone.payments.repository.AccountsRepository;
import com.capstone.payments.repository.BillRepository;
import com.capstone.payments.repository.TransactionsRepsitory;
import com.capstone.payments.serviceImpl.MailService;

@RestController
public class TransactionsController {
	@Autowired
	BillRepository billRepository;
	@Autowired
	AccountsRepository accRepository;
	@Autowired
	TransactionsRepsitory transRepository;
	@Autowired
    private MailService senderService;
	
	@PostMapping("/paymentManual")
	public ResponseEntity<?> paymentManual(@RequestBody PaymentDetails pd) {
		try {
			System.out.println(pd);
			Bill bill = billRepository.findBybillSeqId(pd.getBillSequenceId());
			Accounts acc = accRepository.findByaccountNo(pd.getAccountNo());
			
			if(bill.getAmount() > acc.getCurrentBal()) {
				throw new InsufficientResourcesException("Insufficient Balance");
			}
			else {
				acc.setCurrentBal(acc.getCurrentBal()-bill.getAmount());
				bill.setStatus("PAID");
				accRepository.save(acc);
				billRepository.save(bill);
				Date currentUtilDate = new Date();
				SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String customUtilDate = dateFormatter.format(currentUtilDate);
				Transaction t=new Transaction(customUtilDate,bill.getAmount(),1,pd.getDescription(), bill.getBillSeqId());
				transRepository.save(t);
				senderService.sendSimpleEmail(acc.getEmail(),
		                "Payment Done",
		                "Your payment is done of Rs."+ bill.getAmount()+" of biller" +bill.getBillerCode()+" on " + customUtilDate);
			}
			return new ResponseEntity<>("Payment Done",HttpStatus.ACCEPTED);
		}
		catch (InsufficientResourcesException e) {
			// TODO: handle exception
			return new ResponseEntity<>("Low balance payment rejected",HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Error payment cancelled",HttpStatus.BAD_REQUEST);
		}
		
		
	}
	

	@Scheduled(fixedRate=1*60*1000)
	public void paymentAuto() {
		List<Bill> list = billRepository.findBystatus("PENDING");
		for(Bill b: list) {
			System.out.println(b);
		}
	}
}
