package com.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.entities.User;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void saveUser(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
	}
	
	public List<User> getAllUsers() {
		List<User> users=this.hibernateTemplate.loadAll(User.class);
		return users;
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
