package com.packt.ws;
import javax.xml.ws.Endpoint;
public class EmployeeProfileEndPoint {
	public static void main(String[] args) {
		   Endpoint.publish("http://localhost:8086/ws/user", new EmployeeProfileImpl());
	    }
}


