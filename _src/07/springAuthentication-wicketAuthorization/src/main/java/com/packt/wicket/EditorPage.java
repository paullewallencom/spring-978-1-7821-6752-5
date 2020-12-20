package com.packt.wicket;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;

@AuthorizeInstantiation("ROLE_EDITOR")
public class EditorPage extends WebPage {

}
