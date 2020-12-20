package com.example.vaadin_project5;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ClassBasedViewProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
public class MyLoginView extends Panel implements View {
	private Layout mainLayout;
    public static final String NAME = "";
    Navigator navigator;
    protected static final String CountView = "SecuredView";
    public MyLoginView() {
    	final FormLayout loginlayout=new FormLayout();
		final TextField nameField=new TextField("name");
		final PasswordField passwordField=new PasswordField("password");
		loginlayout.addComponent(nameField);
		loginlayout.addComponent(passwordField);
		Button loginButton = new Button("Login");
		loginlayout.addComponent(loginButton);
		mainLayout = new VerticalLayout();
		mainLayout.addComponent(loginlayout);
		setContent(mainLayout);
		
		loginButton.addClickListener(new Button.ClickListener() {
		public void buttonClick(ClickEvent event) {
			try{
				ServletContext servletContext = VaadinRequestHolder.getRequest().getSession().getServletContext();
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(nameField.getValue(),passwordField.getValue());
				token.setDetails( new WebAuthenticationDetails(VaadinRequestHolder.getRequest()));
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
				AuthenticationManager authManager = wac.getBean(AuthenticationManager.class);
				Authentication authentication = authManager.authenticate(token);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				if(authentication.isAuthenticated()){
				Notification.show(authentication.getPrincipal()+"You are authenticated"+authentication.getAuthorities());
				navigator = new Navigator(getUI().getCurrent(), mainLayout);
				navigator.addView(CountView, new SecuredView());
				navigator.navigateTo(CountView);
				 }
				
			
		} catch (BadCredentialsException e) {

			Notification.show("Bad credentials");
		}
			}
	});

    }

     
	@Override
	public void enter(ViewChangeEvent event) {
		
		
	}

}