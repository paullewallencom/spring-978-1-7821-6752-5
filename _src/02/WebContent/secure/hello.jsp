<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.security.Principal" %>
<html>
<body>

Hello .You are seeing a secured Page now.

	
	<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
 
</body>
</html>