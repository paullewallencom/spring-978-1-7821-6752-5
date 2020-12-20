package com.servlets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.callback.SecurityAssociationHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.servlets.UserCredentialHandler;

/**
 * Servlet implementation class LogonServlet
 */
public class SecurityCheckerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecurityCheckerServlet() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		char[] password = null;
		PrintWriter out=response.getWriter();
		try
		{
			
		SecurityAssociationHandler handler = new SecurityAssociationHandler();
		SimplePrincipal user = new SimplePrincipal(request.getParameter("j_username"));
		password=request.getParameter("j_password").toCharArray();
		handler.setSecurityInfo(user, password);
		System.out.println("password"+password);
		
		CallbackHandler myHandler = new UserCredentialHandler(request.getParameter("j_username"),request.getParameter("j_password"));
		 LoginContext lc = new LoginContext("other", handler);
		 lc.login();
		
		 Subject subject = lc.getSubject();
		 Set principals = subject.getPrincipals();
		 
		List l=new ArrayList();
		  Iterator it = lc.getSubject().getPrincipals().iterator();
	        while (it.hasNext()) {
	        	System.out.println("Authenticated: " + it.next().toString() + "<br>");
	        	out.println("<b><html><body><font color='green'>Authenticated: " + request.getParameter("j_username")+"<br/>"+it.next().toString() + "<br/></font></b></body></html>");
	        	}
	        it = lc.getSubject().getPublicCredentials(Properties.class).iterator();
	        while (it.hasNext()) System.out.println(it.next().toString());
	        
				    lc.logout();
				    
		}	catch (Exception e) {
			out.println("<b><font color='red'>failed authenticatation</font>-</b>"+e);
			 
			 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
