package com.capstone.payments.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.payments.entities.LoggedInUser;
import com.capstone.payments.entities.Users;
import com.capstone.payments.repository.LoggedInUserRepository;
import com.capstone.payments.repository.UsersRepository;
import com.capstone.payments.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	LoggedInUserRepository loggedInUserRepository;

	@Override
	public Users Login(String loginId, String password) {
		List<Users> obj = usersRepository.findByloginId(loginId);
		if (obj.get(0).getPassword().equals(password.toString())) {
			LoggedInUser user = new LoggedInUser(obj.get(0).getLoginId(),
					obj.get(0).getRoleId());
			if (loggedInUserRepository.count() > 0) {
				return null;
			}
			loggedInUserRepository.save(user);
			return obj.get(0);
		}
		return null;
	}

}

/*
  create table logged_in_user(
  `id` int PRIMARY KEY,
  `login_id` varchar(45),
  `role_id` varchar(45)
  );
 */