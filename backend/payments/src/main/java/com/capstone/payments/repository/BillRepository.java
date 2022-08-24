package com.capstone.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.payments.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

}
