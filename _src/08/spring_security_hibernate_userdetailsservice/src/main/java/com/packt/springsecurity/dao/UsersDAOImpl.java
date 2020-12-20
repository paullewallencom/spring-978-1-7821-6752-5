/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.dao;

import com.packt.springsecurity.hibernate.entity.HorrorMovieEntity;
import com.packt.springsecurity.hibernate.entity.UserRole;
import com.packt.springsecurity.hibernate.entity.Users;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anjana.m
 */
public class UsersDAOImpl implements UsersDAO{
  @Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public void addUsers(Users users) {
		this.sessionFactory.getCurrentSession().save(users);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Users> getAllUsers() {
		return this.sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	@Override
	@Transactional
	public void deleteUsers(Integer usersId) {
		Users users = (Users) sessionFactory.getCurrentSession().load(Users.class, usersId);
        if (null != users) {
        	this.sessionFactory.getCurrentSession().delete(users);
        }
	}
      @Override
@Transactional
        public Users findByUserName(String userName) {
		List<Users> userList = new ArrayList<Users>();
		Query query =  (Query) sessionFactory.getCurrentSession().createQuery("from Users u where u.userName = :userName");
		query.setParameter("userName", userName);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}
}
