package com.example.authBasic.model;

import java.util.List;

public class Student extends AppUser {
    private String id;
    private String name;
    private String description;
    private List<Course> courses;
    private String lastName;
    
    public Student(String userName, String password, List<String> roleList, String id, String name, String lastName, String description,
            List<Course> courses) {
        super(userName, password, roleList);
        this.id = id;
        this.name = name;
        this.description = description;
        this.courses = courses;
        this.lastName = lastName;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public List<Course> getCourses() {
        return courses;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}