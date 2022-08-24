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
	@GetMapping("/getRegisteredBillers")
	public List<RegBillers> getRegisteredBillers(){
		int accountNo=1;
		return this.billService.getRegisteredBillers(accountNo);
	}
}
