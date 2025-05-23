package com.yashasvi.ums.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashasvi.ums.dao.RoleDao;
import com.yashasvi.ums.entity.Role;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	public Role createNewRole(Role role) {

		return roleDao.save(role);
	}
}
