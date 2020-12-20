package com.demo.xyz.server;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class PacktGWTAuthenticator implements AuthenticationProvider{
	static Users users=new Users();
	private static Map<String, String> usersMap =users.loadUsers();
	
	@Override
	    public Authentication authenticate(Authentication authentication) 
	            throws AuthenticationException {
	        
	        String mylogin_name = (String) authentication.getPrincipal();
	        String mypassword = (String)authentication.getCredentials();
	        //check username
	        if (usersMap.get(mylogin_name)==null)
	            throw new UsernameNotFoundException(mylogin_name+"credential not found in the UsersMap");
	        //get password
	        String password = usersMap.get(mylogin_name);
	        
	        if (!password.equals(mypassword))
	            throw new BadCredentialsException("Incorrect password-or credential not found in the UsersMap");
	        
	        Authentication packtauthenticator =  new PacktGWTAuthentication("ROLE_AUTHOR", authentication);
	        packtauthenticator .setAuthenticated(true);
	        
	        return packtauthenticator;
	        
	    }

	    @Override
	    public boolean supports(Class<? extends Object> authentication) {
	        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	    }
}
