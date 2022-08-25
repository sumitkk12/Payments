package com.capstone.payments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.payments.entities.RegBillers;

public interface RegBillersRepository extends JpaRepository<RegBillers, Integer>{
	public List<RegBillers> findByaccountNo(int accountNo);
	public List<RegBillers> findByaccountNoAndBillerCode(int accountNo,String billerCode);
}
