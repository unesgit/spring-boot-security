package com.example.authBasic.model;

import java.util.List;

public class AppUser {
    
    private String userName;
    private String password;
    private List<String> roleList;
    
    public AppUser(String userName, String password, List<String> roleList) {
        super();
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<String> getRoleList() {
        return roleList;
    }
    
    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
    
}
