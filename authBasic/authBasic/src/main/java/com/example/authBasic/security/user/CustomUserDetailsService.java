package com.example.authBasic.security.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.authBasic.model.Student;
import com.example.authBasic.services.StudentService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    StudentService studentService;
    
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        
        // Try to find user and its roles, for example here we try to get it
        // from database via a DAO object
        // Do not confuse this foo.bar.User with CurrentUser or spring User,
        // this is a temporary object which holds user info stored in database
        Student student = studentService.findByUserName(username);
        
        // Build user Authority. some how a convert from your custom roles which
        // are in database to spring GrantedAuthority
        Set<String> userRoleDBSet = new HashSet<>();
        userRoleDBSet.add("student");
        List<GrantedAuthority> authorities = buildUserAuthority(userRoleDBSet);
        
        // The magic is happen in this private method !
        return buildUserForAuthentication(student, authorities);
        
    }
    
    private List<GrantedAuthority> buildUserAuthority(Set<String> userRoles) {
        
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        
        // Build user's authorities
        for (String userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole));
        }
        
        return new ArrayList<GrantedAuthority>(setAuths);
    }
    
    // Fill your extended User object (CurrentUser) here and return it
    private User buildUserForAuthentication(Student student, List<GrantedAuthority> authorities) {
        String username = student.getUserName();
        String password = student.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        return new CurrentUser(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities,
                student.getName(), student.getLastName());
        // If your database has more information of user for example
        // firstname,... You can fill it here
        // CurrentUser currentUser = new CurrentUser(....)
        // currentUser.setFirstName( user.getfirstName() );
        // .....
        // return currentUser ;
    }
    
}