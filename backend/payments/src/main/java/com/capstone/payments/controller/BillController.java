package com.capstone.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.payments.entities.Bill;
import com.capstone.payments.service.BillService;

@RestController
public class BillController {
	@Autowired
	BillService billService;
	@GetMapping("/view-sheduled-bill-payments")
	public List<Bill> viewSheduledBillPayments(){
		int accountNo=1;
		return billService.viewSheduledBillPayments(accountNo);
	}
	@GetMapping("/view-payments-done-for-all")
	public List<Bill> viewPaymentsDoneForAll(){
		int accountNo=1;
		return billService.viewPaymentsDoneForAll(accountNo);
	}
	@GetMapping("/view-payments-done-for-selected-biller")
	public List<Bill> viewPaymentsDoneForSelectedBiller(){
		int accountNo=1;
		String billerCode="B002";
		return billService.viewPaymentsDoneForSelectedBiller(accountNo,billerCode);
	}
}
