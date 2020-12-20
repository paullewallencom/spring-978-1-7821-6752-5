
package packt.vaadin;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

public class MyAbstractApplicationServlet extends AbstractApplicationServlet
{
    private WebApplicationContext appContext;
    private Class<? extends Application> applicationClass;

    @Override
    protected Application getNewApplication(HttpServletRequest httpServletRequest) throws ServletException {
         MainApplication mainApplication = (MainApplication) appContext.getBean("applicationBean");
         mainApplication.setWebApplicationContext(appContext);
        return  mainApplication;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response); 
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);   
        appContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
       
    }

	@Override
	protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
		return MainApplication.class;
	}
}
