package com.capstone.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.payments.entities.Bill;
import com.capstone.payments.service.BillService;

@RestController
public class BillController {
	@Autowired
	BillService billService;
	@GetMapping("/view-sheduled-bill-payments/{accountNo}")
	public List<Bill> viewSheduledBillPayments(@PathVariable int accountNo){
		return billService.viewSheduledBillPayments(accountNo);
	}
	@GetMapping("/view-payments-done-for-all/{accountNo}")
	public List<Bill> viewPaymentsDoneForAll(@PathVariable int accountNo){
		return billService.viewPaymentsDoneForAll(accountNo);
	}
	@GetMapping("/view-payments-done-for-selected-biller/{accountNo}/{billerCode}")
	public List<Bill> viewPaymentsDoneForSelectedBiller(@PathVariable int accountNo,@PathVariable String billerCode ){
		return billService.viewPaymentsDoneForSelectedBiller(accountNo,billerCode);
	}
	
	@PostMapping("/createNewBill")
	public Bill createNewBill(@RequestBody Bill bill){
		int roleId=2;
		if(roleId == 1) {
			bill.setBillerCode("B001");
			bill.setConsumerNo(1);
			bill.setStatus("PENDING");
			System.out.println(bill);
			return billService.createNewBill(bill);
		}
		return null;
			
	}
}