/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.service;

import com.packt.springsecurity.dao.UsersDAO;
import com.packt.springsecurity.hibernate.entity.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anjana.m
 */
@Service
public class UsersManagerImpl implements UserManager{
@Autowired
    private UsersDAO UsersDAO;

    public void setUsersDAO(UsersDAO UsersDAO) {
        this.UsersDAO = UsersDAO;
    }
    @Override
	@Transactional
    public void addUsers(Users users) {
        UsersDAO.addUsers(users);
        throw new UnsupportedOperationException("Not supported yet.");
    }
@Override
	@Transactional
    public List<Users> getAllUsers() {
        return UsersDAO.getAllUsers();
        
    }
@Override
	@Transactional
    public void deleteUsers(Integer usersId) {
        UsersDAO.deleteUsers(usersId);
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}