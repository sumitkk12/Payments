package com.capstone.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.payments.entities.Role;
import com.capstone.payments.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	RoleService roleService;
	@GetMapping("roles/")
	public List<Role> getAllRoles(){
		return this.roleService.getAllRoles();
	}
}
