package com.capstone.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.payments.entities.LoggedInUser;

public interface LoggedInUserRepository extends JpaRepository<LoggedInUser, String> {
}
