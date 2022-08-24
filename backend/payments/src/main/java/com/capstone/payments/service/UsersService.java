package com.capstone.payments.service;

import com.capstone.payments.entities.Users;

public interface UsersService {
	Users Login(String loginId, String password);
}
