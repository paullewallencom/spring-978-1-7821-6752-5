package packt.vaadin;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;

public class HeaderHorizontalLayout extends HorizontalLayout{
	
	private MainApplication mainApp;

	public HeaderHorizontalLayout(MainApplication mainApp) {
		this.mainApp = mainApp;
		mainApp.setLogoutURL("/j_spring_security_logout");
		addComponents();
	}

	private void addComponents() {
					addComponent(new Label("You are seeing privilaged page"));
					
					
		
	}
	
	
}
