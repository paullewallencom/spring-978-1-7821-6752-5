import com.packt.security.SecuredRole
import com.packt.security.SecuredUser
import com.packt.security.SecuredUserSecuredRole
class BootStrap {
    def init = { servletContext ->
        def userRole = SecuredRole.findByAuthority("ROLE_USER") ?: new SecuredRole(authority: "ROLE_USER").save(flush: true)
        def user = SecuredUser.findByUsername("anjana") ?: new SecuredUser(username: "anjana", password: "anjana123", enabled: true).save(flush: true)
        SecuredUserSecuredRole.create(user, userRole, true)
		
		def userRole_admin = SecuredRole.findByAuthority("ROLE_ADMIN") ?: new SecuredRole(authority: "ROLE_ADMIN").save(flush: true)
        def user_admin = SecuredUser.findByUsername("raghu") ?: new SecuredUser(username: "raghu", password: "raghu123", enabled: true).save(flush: true)
        SecuredUserSecuredRole.create(user_admin, userRole_admin, true)
		
		def userRole_superadmin = SecuredRole.findByAuthority("ROLE_SUPERADMIN") ?: new SecuredRole(authority: "ROLE_SUPERADMIN").save(flush: true)
        def user_superadmin = SecuredUser.findByUsername("packt") ?: new SecuredUser(username: "packt", password: "packt123", enabled: true).save(flush: true)
        SecuredUserSecuredRole.create(user_superadmin, userRole_superadmin, true)
    }
    def destroy = {
    }
}
