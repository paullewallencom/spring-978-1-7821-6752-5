<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/spring-social/facebook/tags" prefix="facebook" %>
<%@ page session="false" %>

<table border="1" bgcolor="#00FF00">
    <tr>
    <td>
        <ul>
         <li><a href="auth/twitter"><img src="resources/social/twitter/sign-in-with-twitter-d.png" border="0"/></a></li>
    <li><a href="auth/facebook"><img src="resources/social/facebook/sign-in-with-facebook.png" border="0"/></a></li>

    <li><a href="auth/linkedin">Sign In with LinkedIn</a></li>
       
     </ul>
        </td>
        <td>
             <form id="signin" action="/signin/authenticate" method="post">
            <table>
                <tr>
    <td><label for="login">Username</label></td>
            <td>
		<input id="login" name="j_username" type="text" size="25" <c:if test="${not empty signinErrorMessage}">value="${SPRING_SECURITY_LAST_USERNAME}"</c:if> /></td>
	
  		</tr>
                <tr>
                    <td><label for="password">Password</label></td>
                       <td><input id="password" name="j_password" type="password" size="25" />	</td>
                </tr>
                 <tr>
                     <td align="center" colspan="2"><button type="submit">Sign In</button></td>
                       
                </tr>
		
      </table>
                </form>
                </td>
    </tr>
</table>
                
    <p>demo user:</p>
	<ul>
		<li>shami/shami123</li>
		
	</ul>
	
	<p>Or you can <a href="<c:url value="/signup"/>">signup</a> with a new account.</p>


	
<c:if test="${param.error eq 'bad_credentials'}">
  		
  			Your sign in information was incorrect.
  			Please try again or <a href="<c:url value="/signup" />">sign up</a>.
  		</c:if>
  		<c:if test="${param.error eq 'multiple_users'}">
  		
  			Try again seems like some problem
  		</c:if>

	