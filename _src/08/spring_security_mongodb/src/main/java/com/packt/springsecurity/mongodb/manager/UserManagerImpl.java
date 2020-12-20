/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.mongodb.manager;


import com.packt.springsecurity.mongodb.dao.UsersDAO;
import com.packt.springsecurity.mongodb.documententity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anjana.m
 */
@Service
public class UserManagerImpl implements UserManager{
@Autowired
    private UsersDAO usersDAO;
    public Users findByUserName(String userName) {
      return usersDAO.findByUserName(userName) ;
    }
    
}
