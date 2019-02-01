package com.example.authBasic.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.authBasic.model.Course;
import com.example.authBasic.model.Student;

@Service
public class StudentService {
    
    private static List<Student> students = new ArrayList<>();
    
    static {
        // Initialize Data
        Course course1 = new Course("Course1", "Spring", "10 Steps",
                Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
        
        Student ranga = new Student("Unes", "Pass", Arrays.asList(new String[] { "student" }), "Student1", "Younes", "Nadir",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays.asList(course1, course2)));
        
        students.add(ranga);
    }
    
    public Student retrieveStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    public List<Course> retrieveCourses(String studentId) {
        Student student = retrieveStudent(studentId);
        
        if (student == null) {
            return null;
        }
        
        return student.getCourses();
    }
    
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
    
    public Student findByUserName(String userName) {
        // brought from the DB
        return students.stream().filter(s -> s.getName().equals(userName)).findFirst().get();
    }
}