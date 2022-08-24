package com.capstone.payments.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.payments.service.BillService;
import com.capstone.payments.entities.*;

@RestController
public class RegBillersController{
	@Autowired
	BillService billService;
	@GetMapping("/RegisteredBillers")
	public List<RegBillers> getRegisteredBillers(){
		int accountNo=2;
		return this.billService.getRegisteredBillers(accountNo);
	}
	
	@PostMapping("/RegisteredBillers")
	public RegBillers putRegisteredBillers(@RequestBody RegBillers regBiller) {
		System.out.println(regBiller);
		return this.billService.createNewRegisteredBillers(regBiller);
	}
}
