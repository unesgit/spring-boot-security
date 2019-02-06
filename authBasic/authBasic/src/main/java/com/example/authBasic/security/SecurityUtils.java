/**
 * 
 */
package com.example.authBasic.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @author y.nadir
 *
 */
public class SecurityUtils {
    
    private SecurityUtils() {
        
    }
    
    public static String getConnectedUserName() {
        return ((User) getAuthentication().getPrincipal()).getUsername();
    }
    
    public static String getConnectedUserPassword() {
        return ((User) getAuthentication().getPrincipal()).getPassword();
    }
    
    public static Collection<? extends GrantedAuthority> getConnectedUserRoles() {
        return getAuthentication().getAuthorities();
    }
    
    public static User getConnectedUserDetails() {
        return (User) getAuthentication().getDetails();
    }
    
    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    
}
