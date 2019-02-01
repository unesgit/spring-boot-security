/**
 * 
 */
package com.example.authBasic.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.example.authBasic.security.user.CurrentUser;

/**
 * @author y.nadir
 *
 */
public class SecurityUtils {
    
    private SecurityUtils() {
        
    }
    
    public static String getConnectedUserName() {
        return ((CurrentUser) getAuthentication().getPrincipal()).getUsername();
    }
    
    public static String getConnectedUserPassword() {
        return ((CurrentUser) getAuthentication().getPrincipal()).getPassword();
    }
    
    public static Collection<? extends GrantedAuthority> getConnectedUserRoles() {
        return getAuthentication().getAuthorities();
    }
    
    public static User getConnectedUserDetails() {
        return (CurrentUser) getAuthentication().getDetails();
    }
    
    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    
}
