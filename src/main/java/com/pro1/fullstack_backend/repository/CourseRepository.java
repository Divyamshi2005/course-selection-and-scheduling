package com.pro1.fullstack_backend.repository;

import com.pro1.fullstack_backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
