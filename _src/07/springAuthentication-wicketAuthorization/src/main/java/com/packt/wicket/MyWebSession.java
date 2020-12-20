package com.packt.wicket;

import org.apache.log4j.Logger;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class MyWebSession extends AuthenticatedWebSession {

    private static final long serialVersionUID = 99551222374558750L;
	@SpringBean(name = "springauthenticationManager")
	private AuthenticationManager springauthenticationManager;

    public MyWebSession(Request request) {
	super(request);
	Injector.get().inject(this);
	
    }
  @Override
    public boolean authenticate(String username, String password) {
	boolean authenticated = true;
	try {
	    Authentication authentication = springauthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
		    username, password));
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    authenticated = authentication.isAuthenticated();
	} catch (AuthenticationException e) {
	    
	    authenticated = false;
	}
	return authenticated;
    }

    @Override
    public Roles getRoles() {
	Roles roles = new Roles();
	getRolesIfSignedIn(roles);
	return roles;
    }

    private void getRolesIfSignedIn(Roles roles) {
	if (isSignedIn()) {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    addRolesFromAuthentication(roles, authentication);
	}
    }

    private void addRolesFromAuthentication(Roles roles, Authentication authentication) {
	for (GrantedAuthority authority : authentication.getAuthorities()) {
	    roles.add(authority.getAuthority());
	}
    }

}
