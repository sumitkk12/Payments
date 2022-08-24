package com.capstone.payments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.payments.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{
	public List<Bill> findByconsumerNo(int consumerNo);
	public List<Bill> findByconsumerNoAndStatus(int consumerNo,String status);
	public List<Bill> findByconsumerNoAndBillerCodeAndStatus(int consumerNo, String billerCode, String status);
	public Bill findBybillSeqId(int billSequenceId);
}
