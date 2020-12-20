import org.springframework.ldap.core.DirContextAdapter
import org.springframework.ldap.core.DirContextOperations
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper

 
class MyUserDetailsContextMapper implements UserDetailsContextMapper {
 
    UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection authorities) {
         String fullname = ctx.originalAttrs.attrs['cn'].values[0]
		 String email = ctx.originalAttrs.attrs['mail'].values[0].toString().toLowerCase() 
        def title = ctx.originalAttrs.attrs['sn']
         def userDetails = new MyUserDetails(username, '', true, true, true, true,
            authorities, fullname,email,  title == null ? '' : title.values[0])
         return userDetails
    }
 
    void mapUserToContext(UserDetails user, DirContextAdapter ctx) {
        throw new IllegalStateException("Only retrieving data from LDAP is currently supported")
    }
 
}