/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.mongodb.manager;

import com.packt.springsecurity.mongodb.documententity.Users;

/**
 *
 * @author anjana.m
 */
public interface UserManager {
    public Users findByUserName(String userName);
}
