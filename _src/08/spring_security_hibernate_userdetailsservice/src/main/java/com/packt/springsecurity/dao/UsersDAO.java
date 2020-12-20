/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.dao;

import com.packt.springsecurity.hibernate.entity.HorrorMovieEntity;
import com.packt.springsecurity.hibernate.entity.Users;
import java.util.List;

/**
 *
 * @author anjana.m
 */
public interface UsersDAO {
public void addUsers(Users users); 
	public List<Users> getAllUsers();
	public void deleteUsers(Integer usersId); 
          public Users findByUserName(String userName);
}