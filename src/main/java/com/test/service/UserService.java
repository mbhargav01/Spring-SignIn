package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserDao;
import com.test.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void createUser(User user) {
		 this.userDao.saveUser(user);
	}
	
	public List<User> getUsers() {
		 return this.userDao.getAllUsers();
	}
}
