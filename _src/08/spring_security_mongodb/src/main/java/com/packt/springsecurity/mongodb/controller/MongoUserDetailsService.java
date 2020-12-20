/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.mongodb.controller;

import com.packt.springsecurity.mongodb.documententity.Users;


import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import com.packt.springsecurity.mongodb.manager.UserManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author anjana.m
 */
@Service
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserManager userManager;
    private static final Logger logger = Logger.getLogger(MongoUserDetailsService.class);
private org.springframework.security.core.userdetails.User userdetails;
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Users users = getUserDetail(username);
        System.out.println(username);
         System.out.println(users.getPassword());
          System.out.println(users.getUsername());
           System.out.println(users.getRole());
            return new User(users.getUsername(), users.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,getAuthorities(users.getRole()));
    }

    public List<GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if (role.intValue() == 1) {
            authList.add(new SimpleGrantedAuthority("ROLE_EDITOR"));

        } else if (role.intValue() == 2) {
            authList.add(new SimpleGrantedAuthority("ROLE_AUTHOR"));
        }
        System.out.println(authList);
        return authList;
    }

    public Users getUserDetail(String username) {
        Users users = userManager.findByUserName(username);
        System.out.println(users.toString());
        return users;
    }

   
}