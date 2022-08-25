package com.capstone.payments.repository;

import com.capstone.payments.entities.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
	List<Users> findByloginId(String loginId);
}
