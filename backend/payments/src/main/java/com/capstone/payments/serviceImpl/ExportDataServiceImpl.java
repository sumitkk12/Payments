package com.capstone.payments.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.payments.entities.Bill;
import com.capstone.payments.entities.RegBillers;
import com.capstone.payments.repository.BillRepository;
import com.capstone.payments.repository.RegBillersRepository;
import com.capstone.payments.service.ExportDataService;

@Service
public class ExportDataServiceImpl implements ExportDataService{

	@Autowired
	RegBillersRepository regBillersRepository;
	@Autowired
	BillRepository billRepository;
	
	@Override
	public List<String[]> createCsvData(int accountNo) {
		// find registered bills
		List<RegBillers> regBillers=regBillersRepository.findByaccountNo(accountNo);
		List<String[]> allBills=new ArrayList<>();
		String[] header = { "Bill Sequence ID", "Biller Code", "amount","dueDate","status","consumerNo" };
		allBills.add(header);
		// find bills with consumer no from reg bills and status is pending
		
		for(RegBillers r:regBillers) {
			List<Bill> bills=billRepository.findByconsumerNo(r.getConsumerNo());
			String[] s=new String[6];
			for(Bill b:bills) {
				s[0]=""+b.getBillSeqId();
				s[1]=b.getBillerCode();
				s[2]=""+b.getAmount();
				s[3]=b.getDueDate();
				s[4]=b.getStatus();
				s[5]=b.getConsumerNo();
			}
			allBills.add(s);
		}
		
	    return allBills;
	}

}
