package com.capstone.payments.serviceImpl;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capstone.payments.entities.Bill;
import com.capstone.payments.repository.*;
import com.capstone.payments.entities.RegBillers;
import com.capstone.payments.service.BillService;
@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	RegBillersRepository regBillersRepository;
	@Autowired
	BillRepository billRepository;
	@Override
	public List<RegBillers> getRegisteredBillers(int accountNo){
		return regBillersRepository.findByaccountNo(accountNo);
	}
	
	@Override

	public RegBillers createNewRegisteredBillers(RegBillers regBiller) {
		System.out.println(regBiller);
		return regBillersRepository.save(regBiller);
	}

	public List<Bill> viewSheduledBillPayments(int accountNo) {
		// find registered bills
		List<RegBillers> regBillers=regBillersRepository.findByaccountNo(accountNo);
		// find bills with consumer no from reg bills and status is pending
		List<Bill> allBills=new ArrayList<Bill>();
		for(RegBillers r:regBillers) {
			List<Bill> bills=billRepository.findByconsumerNoAndStatus(r.getConsumerNo(),"PENDING");
			allBills.addAll(bills);
		}
		return allBills;
	}

	@Override
	public List<Bill> viewPaymentsDoneForAll(int accountNo) {
		// find registered bills
		List<RegBillers> regBillers=regBillersRepository.findByaccountNo(accountNo);
		// find bills with consumer no from reg bills and status is pending
		List<Bill> allBills=new ArrayList<Bill>();
		for(RegBillers r:regBillers) {
			List<Bill> bills=billRepository.findByconsumerNoAndStatus(r.getConsumerNo(),"PAID");
			allBills.addAll(bills);
		}
		return allBills;
	}

	@Override
	public List<Bill> viewPaymentsDoneForSelectedBiller(int accountNo, String billerCode) {
		// find registered bills
		List<RegBillers> regBillers=regBillersRepository.findByaccountNoAndBillerCode(accountNo,billerCode);
		// find bills with consumer no from reg bills and status is pending
		List<Bill> allBills=new ArrayList<Bill>();
		for(RegBillers r:regBillers) {
			List<Bill> bills=billRepository.findByconsumerNoAndStatus(r.getConsumerNo(),"PAID");
			allBills.addAll(bills);
		}
		return allBills;
	}

}
