package com.capstone.payments.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.payments.repository.*;
import com.capstone.payments.entities.RegBillers;
import com.capstone.payments.service.BillService;
@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	RegBillersRepository rbr;
	@Override
	public List<RegBillers> getRegisteredBillers(int accountNo){
		return rbr.findByaccountNo(accountNo);
	}
	
	@Override
	public RegBillers createNewRegisteredBillers(RegBillers regBiller) {
		System.out.println(regBiller);
		return rbr.save(regBiller);
	}
}
