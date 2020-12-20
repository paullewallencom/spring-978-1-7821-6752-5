package com.example.vaadin_project5;

import javax.servlet.ServletContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class SecuredView extends Panel implements View {
    public static final String NAME = "count";
    private Layout mainLayout;
    Navigator navigator;
    protected static final String MainView = "LoginView";
    public SecuredView() {
    	mainLayout = new VerticalLayout();
    	mainLayout.addComponent(new Label("You are seeing a secured page"));
    	Button logoutButton = new Button("Logout");
    	mainLayout.addComponent(logoutButton);
        setContent(mainLayout);
        logoutButton.addClickListener(new Button.ClickListener() {
    		public void buttonClick(ClickEvent event) {
    			try{
    				ServletContext servletContext = VaadinRequestHolder.getRequest().getSession().getServletContext();
    				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    				LogoutHandler logoutHandler = wac.getBean(LogoutHandler.class);
    				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    				logoutHandler.logout(VaadinRequestHolder.getRequest(), null, authentication);
    				
    				Notification.show("You are logged out");
    				navigator = new Navigator(getUI().getCurrent(), mainLayout);
    				navigator.addView(MainView, new MyLoginView());
    				navigator.navigateTo(MainView);
    				} catch (BadCredentialsException e) {

    			Notification.show("Bad credentials");
    		}
    			}
    	});
    }

    public void enter(ViewChangeEvent event) {

    }

}