/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.dao;


import com.packt.springsecurity.hibernate.entity.UserRole;
import java.util.List;

/**
 *
 * @author anjana.m
 */
public interface UserRoleDAO {

	public void addUserRole(UserRole userRole); 
	public List<UserRole> getAllUserRoles() ;
	public void deleteUserRole(Integer userRoleId); 
	}
