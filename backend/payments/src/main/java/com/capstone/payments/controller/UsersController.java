package com.capstone.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.payments.entities.Input;
import com.capstone.payments.service.UsersService;

@RestController
public class UsersController {

	String user = null;
	@Autowired
	UsersService usersService;

	@PostMapping(value = "/login")
	public String login(@RequestBody Input inp) {
		if (this.usersService.Login(inp.getUser(), inp.getPass())) {
			user = inp.getUser();
		} else
			System.out.println("Login Failed");
		return user;
	}
	// Call Login(Username,Password)
}
