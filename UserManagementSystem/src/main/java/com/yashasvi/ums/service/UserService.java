package com.yashasvi.ums.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashasvi.ums.dao.UserDao;
import com.yashasvi.ums.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User registerNewUser(User user) {
		return userDao.save(user);
	}
}
