package com.demo.xyz.server;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.demo.xyz.client.PacktAuthenticatorService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PacktAuthenticatorServiceImpl extends RemoteServiceServlet  implements PacktAuthenticatorService {

	@Override
	public String authenticateServer() {
		Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
				        if (authentication==null){
				            System.out.println("looks like you have not logged in.");
				            return null;
				        }
					        else {
					        	System.out.println(authentication.getPrincipal().toString());
					        	System.out.println(authentication.getName().toString());
					        	System.out.println(authentication.getDetails().toString());
					            return (String) authentication.getPrincipal();
					        }
				         
	}

}
