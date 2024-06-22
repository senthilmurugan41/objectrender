package com.modelrender.objectrenderer.repo;

import com.modelrender.objectrenderer.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    Course findByName(String name);
}
