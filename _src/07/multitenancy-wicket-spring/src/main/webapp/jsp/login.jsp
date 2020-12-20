<%@page errorPage="/login_error.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <font color="red">
    <%
String message=request.getParameter("error")    ;
out.println(message);
%>
	</font>
        <div align="center">
	Login here--customized---login page
	<form action="/Multitenant-spring-security-wicket/j_spring_security_check" method="post">
	<table>
		<tr>
			<td>
				User
			</td>
			<td>
				<input name="j_username">
			</td>
		</tr>
		<tr>
			<td>
				Password
			</td>
			<td>
				<input type="password" name="j_password"/>
			</td>
		</tr>
                
                		<tr><td><label>Tenant:&nbsp;</label></td><td> <select style="width:146px" id="tenant" name="tenant"><option value="">Choose Tenant</option><option value="Tenant1">Tenant 1</option><option value="Tenant2">Tenant 2</option></select></td>
                                </tr>
		<tr>
			<td>
				<input type="submit" value="login">
			<td>
		</tr>
	</table>
	</form>	
	</div>
</body>
</html>