package com.capstone.payments.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.payments.entities.Bill;
import com.capstone.payments.entities.RegBillers;
import com.capstone.payments.repository.BillRepository;
import com.capstone.payments.repository.RegBillersRepository;
import com.capstone.payments.service.BillService;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	RegBillersRepository regBillersRepository;
	@Autowired
	BillRepository billRepository;
	@Override
	public List<Bill> viewSheduledBillPayments(int accountNo) {
		// find registered bills
		List<RegBillers> regBillers=regBillersRepository.findByAccountNo(accountNo);
		// find bills with consumer no from reg bills and status is pending
		List<Bill> allBills=new ArrayList<Bill>();
		for(RegBillers r:regBillers) {
			List<Bill> bills=billRepository.findByconsumerNoAndStatus(r.getConsumerNo(),"PENDING");
			allBills.addAll(bills);
		}
		return allBills;
	}

}
