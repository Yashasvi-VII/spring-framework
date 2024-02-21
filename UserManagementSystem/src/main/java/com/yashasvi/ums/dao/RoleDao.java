package com.yashasvi.ums.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yashasvi.ums.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
