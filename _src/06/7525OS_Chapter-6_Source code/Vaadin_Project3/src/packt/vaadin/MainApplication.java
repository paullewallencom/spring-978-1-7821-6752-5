
package packt.vaadin;

import java.util.Collection;


import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import packt.vaadin.security.Roles;


@Component("applicationBean")
@Scope("prototype")
public class MainApplication extends Application {

	public WebApplicationContext webappContext;

	@Override
	public void init() {
		Window window;
		window = new Window("My Vaadin Application");
		window.addComponent(new HeaderHorizontalLayout(this));
		window.addComponent(new BodyHorizontalLayout(this));
		window.addComponent(new FooterHorizontalLayout(this));
		setMainWindow(window);
	}


	public void setWebApplicationContext(WebApplicationContext appContext){
		this.webappContext = webappContext;
	}
	
}

