/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.service;

import com.packt.springsecurity.hibernate.entity.UserRole;
import java.util.List;

/**
 *
 * @author anjana.m
 */
public interface UserRoleManager {

	public void addUserRole(UserRole userRole); 
	public List<UserRole> getAllUserRoles() ;
	public void deleteUserRole(Integer userRoleId); 
}