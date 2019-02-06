package com.example.authBasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.authBasic.model.Course;
import com.example.authBasic.model.Student;
import com.example.authBasic.services.StudentService;

@RestController
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/students/{studentId}/courses")
    public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
        return studentService.retrieveCourses(studentId);
    }
    
    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
        // Students can only be viewed by admin Role.@See
        // StudentService.getStudents() annotation
        return studentService.getStudents();
    }
}