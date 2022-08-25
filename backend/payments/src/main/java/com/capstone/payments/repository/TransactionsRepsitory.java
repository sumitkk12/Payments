package com.capstone.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capstone.payments.entities.Transaction;

public interface TransactionsRepsitory extends JpaRepository<Transaction,Integer>{

}
