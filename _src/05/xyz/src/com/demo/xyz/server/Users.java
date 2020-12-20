package com.demo.xyz.server;

import java.util.HashMap;
import java.util.Map;

public class Users {
	public Map<String, String> getUsersMap() {
		return usersMap;
	}

	public void setUsersMap(Map<String, String> usersMap) {
		
		this.usersMap = usersMap;
	}

	private Map<String, String> usersMap = new HashMap<String, String>();
	
	public Map<String, String> loadUsers(){
	     usersMap.put("rashmi", "rashmi123");
        usersMap.put("shami", "shami123");
        usersMap.put("ravi", "ravi123");
        usersMap.put("ratty", "ratty123");
		return usersMap;
    }
	
}
