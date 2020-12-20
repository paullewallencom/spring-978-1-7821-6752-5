/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.mongodb.dao;

import com.packt.springsecurity.mongodb.documententity.HorrorMovieEntity;
import com.packt.springsecurity.mongodb.documententity.Users;
public interface UsersDAO {

	
          public Users findByUserName(String userName);
}