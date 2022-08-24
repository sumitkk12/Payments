package com.capstone.payments.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.payments.entities.Users;
import com.capstone.payments.repository.UsersRepository;
import com.capstone.payments.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public boolean Login(String loginId, String password) {
		Users obj = usersRepository.findByLoginId(loginId);
		if (obj.getPassword() == password) {
			return true;
		}
		return false;
	}

}
