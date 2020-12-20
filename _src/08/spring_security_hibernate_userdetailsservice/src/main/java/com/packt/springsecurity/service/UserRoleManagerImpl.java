/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.service;

import com.packt.springsecurity.dao.UserRoleDAO;
import com.packt.springsecurity.hibernate.entity.UserRole;
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
public class UserRoleManagerImpl implements UserRoleManager{
@Autowired
    private UserRoleDAO userRoleDAO;
@Override
	@Transactional
    public void addUserRole(UserRole userRole) {
        userRoleDAO.addUserRole(userRole);
        throw new UnsupportedOperationException("Not supported yet.");
    }
@Override
	@Transactional
    public List<UserRole> getAllUserRoles() {
       
        return userRoleDAO.getAllUserRoles();
        
    }
@Override
	@Transactional
    public void deleteUserRole(Integer userRoleId) {
         userRoleDAO.deleteUserRole(userRoleId);
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
