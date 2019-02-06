package com.example.authBasic.model;

import java.util.List;

public class Course {
    private String id;
    private String name;
    private String description;
    private List<String> steps;
    
    public Course(String id, String name, String description, List<String> steps) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.steps = steps;
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
    
    public List<String> getSteps() {
        return steps;
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
    
    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
    
}