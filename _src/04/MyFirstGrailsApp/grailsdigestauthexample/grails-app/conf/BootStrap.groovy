import com.packt.*;
class BootStrap {
    def init = { servletContext ->
        def userRole = SecuredRole.findByAuthority("ROLE_USER") ?: new SecuredRole(authority: "ROLE_USER").save(flush: true)
        def user = SecuredUser.findByUsername("anjana") ?: new SecuredUser(username: "anjana", password: "anjana123", enabled: true).save(flush: true)
        SecuredUserSecuredRole.create(user, userRole, true)
    }
    def destroy = {
    }
}
