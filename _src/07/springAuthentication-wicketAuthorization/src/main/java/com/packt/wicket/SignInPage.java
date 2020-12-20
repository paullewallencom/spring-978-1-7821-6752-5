package com.packt.wicket;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.value.ValueMap;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
public final class SignInPage extends WebPage
{
    /**
     * Constructor
     */
    public SignInPage()
    {
        final SignInForm form = new SignInForm("signinForm");
	add(form);
    }

    /**
     * Sign in form
     */
    public final class SignInForm extends Form<Void>
    {
       private String username;
		private String password;

        
        public SignInForm(final String id)
        {
            super(id);
			setModel(new CompoundPropertyModel(this));
            // Attach textfield components that edit properties map model
            add(new RequiredTextField("username"));
            add(new PasswordTextField("password"));
			 add(new FeedbackPanel("feedback"));
        }

        @Override
        public final void onSubmit()
        {
            // Get session info
            MyWebSession session = getMySession();

            // Sign the user in
            if (session.signIn(username,password))
            {
              
                    setResponsePage(getApplication().getHomePage());
                
            }
            else
            {
                // Get the error message from the properties file associated with the Component
                String errmsg = getString("loginError", null, "Unable to sign you in");

               
            }
        }

       

        /**
         * @return
         */
        private MyWebSession getMySession()
        {
            return (MyWebSession)getSession();
        }
    }
}