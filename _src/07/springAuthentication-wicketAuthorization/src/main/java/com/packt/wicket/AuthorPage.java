package com.packt.wicket;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.Page;
import com.packt.wicket.SomeInterfaceImpl;
@AuthorizeInstantiation("ROLE_AUTHOR")
public class AuthorPage extends WebPage {

@SpringBean
private SomeInterfaceImpl someInterfaceImpl;

public AuthorPage(final PageParameters parameters) {
		super(parameters);
		add(new Label("msg", someInterfaceImpl.method1()));
		add(new Link("Editor"){
	    @Override
	    public void onClick() {
		Page next = new EditorPage();
		setResponsePage(next);
	    }
	});
	add(new Link("Logout"){
	    @Override
	    public void onClick() {
		getSession().invalidate();
		Page next = new HomePage(parameters);
		setResponsePage(next);
	    }
	});
}
}
