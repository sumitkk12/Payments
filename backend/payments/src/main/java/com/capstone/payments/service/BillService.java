package com.capstone.payments.service;


import java.util.List;

import com.capstone.payments.entities.Bill;
import com.capstone.payments.entities.RegBillers;

public interface BillService {
	Bill createNewBill(Bill bill);
	List<Bill> viewSheduledBillPayments(int accountNo);
	List<RegBillers> getRegisteredBillers(int accountNo);

	RegBillers createNewRegisteredBillers(RegBillers regBiller);

	List<Bill> viewPaymentsDoneForAll(int accountNo);
	List<Bill> viewPaymentsDoneForSelectedBiller(int accountNo,String billerCode);
	
}
