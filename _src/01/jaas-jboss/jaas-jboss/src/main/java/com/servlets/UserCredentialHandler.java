package com.servlets;
import java.io.IOException;
import javax.*;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
class UserCredentialHandler implements CallbackHandler {
	 private String user, pass;

	 UserCredentialHandler(String user, String pass) {
	 super();
	 this.user = user;
	 this.pass = pass;
	 }
	 @Override
	 public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
	 for (int i = 0; i < callbacks.length; i++) {
	 if (callbacks[i] instanceof NameCallback) {
	 NameCallback nc = (NameCallback) callbacks[i];
	 nc.setName(user);
	 } else if (callbacks[i] instanceof PasswordCallback) {
	 PasswordCallback pc = (PasswordCallback) callbacks[i];
	 pc.setPassword(pass.toCharArray());
	 } else {
	 throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
	 }
	 }
	 }

	
	 }