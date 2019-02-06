package com.example.authBasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.authBasic.model.Course;
import com.example.authBasic.services.StudentService;

@RestController

public class AdminController {
    
    @Autowired
    private StudentService studentService;
    
    @RequestMapping(value = "/admin/courses", method = RequestMethod.GET)
    public List<Course> retriveCourses() {
        return studentService.retrieveCourses();
    }
    
}