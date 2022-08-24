package com.capstone.payments.controller;

import java.security.PrivilegedActionException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.payments.entities.Bill;
import com.capstone.payments.service.BillService;

import net.bytebuddy.asm.Advice.This;

@RestController
public class BillController {
	@Autowired
	BillService billService;
	@GetMapping("/view-sheduled-bill-payments/{accountNo}")
	public ResponseEntity<?> viewSheduledBillPayments(@PathVariable int accountNo){
		try {
			return new ResponseEntity<>(billService.viewSheduledBillPayments(accountNo),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>("Error occurred while fetching sheduled bills ", HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/view-payments-done-for-all/{accountNo}")
	public ResponseEntity<?> viewPaymentsDoneForAll(@PathVariable int accountNo){
		try {
			return new ResponseEntity<>(billService.viewPaymentsDoneForAll(accountNo),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("unable to fetch payments done for "+accountNo,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/view-payments-done-for-selected-biller/{accountNo}/{billerCode}")
	public ResponseEntity<?> viewPaymentsDoneForSelectedBiller(@PathVariable int accountNo,@PathVariable String billerCode ){
		try {
			return new ResponseEntity<>(billService.viewPaymentsDoneForSelectedBiller(accountNo,billerCode),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("unable to get payments done for "+accountNo+" with biller code "+billerCode,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/createNewBill")
	public ResponseEntity<?> createNewBill(@RequestBody Bill bill){
		int roleId=2;
		try {
			if(roleId == 1) {
				bill.setBillerCode("B001");
				bill.setConsumerNo(1);
				bill.setStatus("PENDING");
				System.out.println(bill);
				return new ResponseEntity<>(billService.createNewBill(bill),HttpStatus.CREATED);
			}
			throw new SecurityException("Not privilleged user");
		}catch (SecurityException e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Unable to create new bill",HttpStatus.BAD_REQUEST);
		}
			
	}
}
