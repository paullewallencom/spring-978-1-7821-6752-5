package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProtectedServlets
 */
public class ProtectedServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProtectedServlets() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try
		{
			out.println("Hello User");
		
			out.println("Authtype:"+request.getAuthType());
			out.println("User Principal:"+request.getUserPrincipal());
			out.println("User role:"+request.isUserInRole("role1"));
		}
		catch (Exception e) {
			out.println("<b><font color='red'>failed authenticatation</font>-</b>"+e);
			 
			 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
