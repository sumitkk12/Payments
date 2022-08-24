package com.capstone.payments.controller;

import javax.persistence.Entity;

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

	// @PostMapping(value = "/hello", produces = "application/json", consumes =
	// "application/json")
	// public String hello(@RequestBody String user) {
	// return user;
	// }

	@PostMapping(value = "/login")
	public String login(@RequestBody Input inp) {
		System.out.println("HELLO WORLD------------------------");
		if (this.usersService.Login(inp.getUser(), inp.getPass())) {
			user = inp.getUser();
		}
		// login failed
		System.out.println("Login Failed");
		return inp.getUser();
	}
	// Call Login(Username,Password)
}
