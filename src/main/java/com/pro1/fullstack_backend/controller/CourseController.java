package com.pro1.fullstack_backend.controller;

import com.pro1.fullstack_backend.entity.Course;
import com.pro1.fullstack_backend.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course saveCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }
}
