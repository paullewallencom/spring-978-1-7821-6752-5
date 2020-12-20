import org.springframework.security.core.GrantedAuthority 
import org.springframework.security.core.userdetails.User  
class MyUserDetails extends User {   

 String fullname 
 String email 
 String title 
 
MyUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection authorities, String fullname,
String email, String title) {  
 super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities)   
this.fullname = fullname 
this.email = email 
this.title = title 
 }  
 } 