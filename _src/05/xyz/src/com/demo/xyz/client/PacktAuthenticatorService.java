package com.demo.xyz.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("packtauth")
public interface PacktAuthenticatorService extends RemoteService{
	String authenticateServer() ;
}
