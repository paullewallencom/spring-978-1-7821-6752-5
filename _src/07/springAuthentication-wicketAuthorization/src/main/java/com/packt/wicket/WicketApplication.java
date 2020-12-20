package com.packt.wicket;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import com.packt.wicket.MyWebSession;
/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.packt.wicket.Start#main(String[])
 */
 
public class WicketApplication  extends AuthenticatedWebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}
 @Override
    protected Class<? extends WebPage> getSignInPageClass() {
	return SignInPage.class;
    }
	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
	getComponentInstantiationListeners().add(new SpringComponentInjector(this));

		// add your configuration here
	}
	@Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
	return MyWebSession.class;
    }
}
