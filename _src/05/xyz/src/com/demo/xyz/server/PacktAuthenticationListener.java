package com.demo.xyz.server;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
public class PacktAuthenticationListener implements ApplicationListener<AbstractAuthenticationEvent>{
	@Override
	 public void onApplicationEvent(AbstractAuthenticationEvent event) {
	  
	 final StringBuilder mybuilder = new StringBuilder();
	        mybuilder.append("AN AUHTHENTICATION EVENT ");
	        mybuilder.append(event.getClass().getSimpleName());
	        mybuilder.append("*** ");
	        mybuilder.append(event.getAuthentication().getName());
	        mybuilder.append("$$$DETAILS OF THE EVENT: ");
	        mybuilder.append(event.getAuthentication().getDetails());

	        if (event instanceof AbstractAuthenticationFailureEvent) {
	            mybuilder.append("$$$ EXCEPTION HAS OCCURED: ");
	            mybuilder.append(((AbstractAuthenticationFailureEvent) event).getException().getMessage());
	        }

	      

	 }
}
