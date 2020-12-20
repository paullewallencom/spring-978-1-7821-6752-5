/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.service;

import com.packt.springsecurity.dao.UsersDAO;
import com.packt.springsecurity.hibernate.entity.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author anjana.m
 */
public class MyUserDetails implements UserDetailsService {
@Autowired
    private UsersDAO UsersDAO;
   public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		Users users= UsersDAO.findByUserName(userName);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new User(
				users.getUserName(), 
				users.getUserPassword(), 
				enabled, 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked,
				getAuthorities(users.getRole().getRoleId().intValue()));
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
                System.out.println("authList----------->"+authList);
		return authList;
	}
	
	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 1) {
			roles.add("ROLE_EDITOR");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_AUTHOR");
		}
		return roles;
	}
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
                      System.out.println("role----------->"+role);
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
