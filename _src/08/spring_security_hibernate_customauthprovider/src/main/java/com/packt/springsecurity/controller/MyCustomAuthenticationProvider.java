/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author anjana.m
 */
public class MyCustomAuthenticationProvider implements AuthenticationProvider {
    @Override
public boolean supports(Class<? extends Object> authentication)
{
return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
}
 
private static Map<String, String> APP_USERS = new HashMap<String, String>();
private static List<GrantedAuthority> APP_ROLES = new ArrayList<GrantedAuthority>();
static
{
APP_USERS.put("ravi", "ravi123");
APP_USERS.put("chitra", "chitra123");
APP_USERS.put("Vikash", "Vikash123");
APP_ROLES.add(new SimpleGrantedAuthority("ROLE_EDITOR"));
}
 
@Override
public Authentication authenticate(Authentication auth)
{
if (APP_USERS.containsKey(auth.getPrincipal()))
{
    System.out.println(auth.getPrincipal());
     System.out.println(auth.getAuthorities());
          System.out.println(auth.getCredentials());
return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(),
APP_ROLES);
}
throw new BadCredentialsException("Username/Password does not match for "
+ auth.getPrincipal());
}
}

