package com.example.vaadin_project3;

import com.vaadin.Application;
import com.vaadin.ui.*;

/**
 * Main application class.
 */
public class Vaadin_project3Application extends Application {

	@Override
	public void init() {
		Window mainWindow = new Window("Vaadin_project3 Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}

