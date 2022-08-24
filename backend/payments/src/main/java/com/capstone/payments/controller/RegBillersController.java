package com.capstone.payments.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.payments.service.BillService;
import com.capstone.payments.entities.*;

@RestController
public class RegBillersController{
	@Autowired
	BillService billService;
	@GetMapping("/RegisteredBillers/{accountNo}")
	public ResponseEntity<?> getRegisteredBillers(@PathVariable int accountNo){
		try {
			return new ResponseEntity<>(this.billService.getRegisteredBillers(accountNo),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("unable to get registered billers for "+accountNo,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/RegisteredBillers")
	public ResponseEntity<?> putRegisteredBillers(@RequestBody RegBillers regBiller) {
		System.out.println(regBiller);
		try {
			return new ResponseEntity<>(this.billService.createNewRegisteredBillers(regBiller),HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>("Unable to register new biller for "+regBiller.getAccountNo(),HttpStatus.BAD_REQUEST);
		}
		
	}
}
