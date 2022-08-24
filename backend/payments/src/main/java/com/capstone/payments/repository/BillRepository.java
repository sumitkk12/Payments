package com.capstone.payments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.payments.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{
	public List<Bill> findByconsumerNo(int consumerNo);
	public List<Bill> findByconsumerNoAndStatus(int consumerNo,String status);
}
