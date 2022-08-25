package com.capstone.payments.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
import com.capstone.payments.entities.RegBillers;
import com.capstone.payments.entities.Transaction;
import com.capstone.payments.repository.AccountsRepository;
import com.capstone.payments.repository.BillRepository;
import com.capstone.payments.repository.RegBillersRepository;
import com.capstone.payments.repository.TransactionsRepsitory;
import com.capstone.payments.serviceImpl.MailService;

@RestController
public class TransactionsController {
	@Autowired
	RegBillersRepository rbr;
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
	public void paymentAuto() throws ParseException {
		try {
			List<Bill> list = billRepository.findBystatus("PENDING");
			for(Bill b: list) {
				Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(b.getDueDate());
				Date currDate = new Date();
				
				long dayDiff = TimeUnit.DAYS.convert(dueDate.getTime() - currDate.getTime(), TimeUnit.MILLISECONDS);
				//System.out.println(dayDiff);
				
				if(dueDate.compareTo(currDate)==1 && dayDiff <=3) {
					RegBillers regBiller = rbr.findByconsumerNo(b.getConsumerNo());
					if(regBiller.getAutoPay()==1 && b.getAmount() <= regBiller.getAutopayLimit()) {
						int accountNo = regBiller.getAccountNo();
						int billSeqId = b.getBillSeqId();
						//-------------------------------------------------------//
						Accounts acc = accRepository.findByaccountNo(accountNo);
						
						if(b.getAmount() > acc.getCurrentBal()) {
							throw new InsufficientResourcesException("Insufficient Balance");
						}
						else {
							acc.setCurrentBal(acc.getCurrentBal()-b.getAmount());
							b.setStatus("PAID");
							accRepository.save(acc);
							billRepository.save(b);
							Date currentUtilDate = new Date();
							SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String customUtilDate = dateFormatter.format(currentUtilDate);
							Transaction t=new Transaction(customUtilDate,b.getAmount(),1,"Auto Payment", b.getBillSeqId());
							transRepository.save(t);
							senderService.sendSimpleEmail(acc.getEmail(),
					                "Payment Done",
					                "Your payment is done of Rs."+ b.getAmount()+" of biller" +b.getBillerCode()+" on " + customUtilDate);
						}
					}
				}
				

			}
		}
		catch(Exception e) {
			System.out.println("Auto Payment Failed");
		}
	
	}
}
