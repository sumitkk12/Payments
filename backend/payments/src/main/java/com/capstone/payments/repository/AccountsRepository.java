package com.capstone.payments.repository;

import com.capstone.payments.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountsRepository extends JpaRepository<Accounts, Integer>{
	public Accounts findByaccountNo(int accountNo);
}
