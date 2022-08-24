package com.capstone.payments.serviceImpl;

import java.util.List;

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
		List<Users> obj = usersRepository.findByloginId(loginId);
		System.out.println(obj.get(0).getPassword());
		System.out.println(password);
		if (obj.get(0).getPassword().equals(password.toString())) {
			return true;
		}
		return false;
	}

}
