/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.service;

import com.packt.springsecurity.hibernate.entity.Users;
import java.util.List;

/**
 *
 * @author anjana.m
 */
public interface UserManager {
  public void addUsers(Users users); 
	public List<Users> getAllUsers();
	public void deleteUsers(Integer usersId); 
}