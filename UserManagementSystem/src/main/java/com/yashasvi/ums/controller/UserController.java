package com.yashasvi.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yashasvi.ums.entity.User;
import com.yashasvi.ums.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	private String userUrlAccessMessage = "This url is only accessible for user";
	private String adminUrlAccessMessage = "This url is only accessible for admin";

	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}

	@GetMapping({ "/forAdmin" })
	public String forAdmin() {
		return adminUrlAccessMessage;
	}

	@GetMapping({ "/forUser" })
	public String forUser() {
		return userUrlAccessMessage;
	}
}
