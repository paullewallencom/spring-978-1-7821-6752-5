Run the application with the following commands:
 $mvn clean compile install
 $mvn tomcat:run-- for running on tomcat server
 $mvn jetty:run-- for running on jetty server
 -------------------------------------------------
 The application context.xml file work hardcoded user name password.
 You  can make it work with database by adding the below commands
 		<http auto-config="true">
         <intercept-url pattern="/spring-security-wicket/**" access="ROLE_SELLER"/> 
         <intercept-url pattern="/spring-security-wicket/*.*" access="ROLE_SELLER"/> 
         <intercept-url pattern="/**" access="ROLE_SELLER" />
      <http-basic /> 
</http>

	<authentication-manager> 
	   <authentication-provider> 
 		<jdbc-user-service data-source-ref="MySqlDS" 
 		   users-by-username-query=" 
 		      select username,password, enabled   
		      from users1 where username=?"  
 
		   authorities-by-username-query=" 
		      select u.username, ur.role from users1 u, user_roles ur  
	      where u.user_id = ur.user_id and u.username =?  " /> 
	   </authentication-provider>
	   	</authentication-manager>
------------------------------------------------------------
