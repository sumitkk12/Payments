package com.capstone.payments.service;


import java.util.List;

import com.capstone.payments.entities.Bill;
import com.capstone.payments.entities.RegBillers;

public interface BillService {
	List<Bill> viewSheduledBillPayments(int accountNo);
	List<RegBillers> getRegisteredBillers(int accountNo);
}
