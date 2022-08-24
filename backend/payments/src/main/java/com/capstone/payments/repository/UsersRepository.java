package com.capstone.payments.repository;

import com.capstone.payments.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
	Users findByLoginId(String loginId);
}
