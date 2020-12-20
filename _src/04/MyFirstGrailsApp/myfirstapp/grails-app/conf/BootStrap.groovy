import org.packt.SecuredUser;
import org.packt.SecuredRole;
import org.packt.SecuredUserSecuredRole
class BootStrap {
	
	transient springSecurityService
	
    def init = { servletContext ->
		
		if(!SecuredUser.count()){
			/*The default password is 'password'*/
			def password = 'password'
			def user = new SecuredUser(username : 'anjana', password:'anjana123',enabled:true,
				accountExpired : false , accountLocked : false ,passwordExpired : false).save(flush: true, insert: true)
			def role = new SecuredUser(authority : 'ROLE_USER').save(flush: true, insert: true)
			
			/*create the first user role map*/
			SecuredUserSecuredRole.create user , role , true
		}
		
    }
    def destroy = {
    }
}