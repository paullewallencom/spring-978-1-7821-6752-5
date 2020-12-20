/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.dao;

import com.packt.springsecurity.hibernate.entity.HorrorMovieEntity;
import com.packt.springsecurity.hibernate.entity.UserRole;
import java.util.List;
import com.packt.springsecurity.dao.UserRoleDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anjana.m
 */
public class UserRoleDAOImpl implements UserRoleDAO{
 @Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public void addUserRole(UserRole userRole) {
		this.sessionFactory.getCurrentSession().save(userRole);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserRole> getAllUserRoles() {
		return this.sessionFactory.getCurrentSession().createQuery("from UserRole").list();
	}
        @Override
	@Transactional
	public void deleteUserRole(Integer userRoleId) {
		UserRole userRole = (UserRole) sessionFactory.getCurrentSession().load(HorrorMovieEntity.class, userRoleId);
        if (null != userRole) {
        	this.sessionFactory.getCurrentSession().delete(userRole);
        }
	}
}
