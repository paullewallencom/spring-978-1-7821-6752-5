package com.packt.ws;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService(endpointInterface = "com.packt.ws.EmployeeProfile")
public class EmployeeProfileImpl implements EmployeeProfile {

	
	public String getSalary() {
		// TODO Auto-generated method stub
		return "getSalary():no salary for the month";
	}

}
