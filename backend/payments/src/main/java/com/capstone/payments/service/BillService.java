package com.capstone.payments.service;

import java.util.List;

import com.capstone.payments.entities.Bill;

public interface BillService {
	List<Bill> viewSheduledBillPayments(int accountNo);
	
}
