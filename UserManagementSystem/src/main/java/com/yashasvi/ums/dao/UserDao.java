package com.yashasvi.ums.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yashasvi.ums.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {

}
