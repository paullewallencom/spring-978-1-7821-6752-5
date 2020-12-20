package com.packt.wicket;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.Page;

public class HomePage extends WebPage {
private static final long serialVersionUID = 1L;
@SpringBean
private SomeInterfaceImpl someInterfaceImpl;
	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		add(new Label("msg", someInterfaceImpl.method1()));
		add(new Link("click if you are Editor"){
	    @Override
	    public void onClick() {
		Page next = new EditorPage();
		setResponsePage(next);
	    }
	});

	add(new Link("Click if You are Author"){
	    @Override
	    public void onClick() {
		Page next = new AuthorPage(parameters);
		setResponsePage(next);
	    }
	});
	
	
}
   
}
