package com.demo.xyz.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

public interface PacktAuthenticatorServiceAsync {
	void authenticateServer(AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
