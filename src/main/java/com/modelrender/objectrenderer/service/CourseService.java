package com.modelrender.objectrenderer.service;

import com.modelrender.objectrenderer.entity.Course;

import java.util.List;

public interface CourseService {
 Course addCourse(Course course);
 List<Course> findAllCourse();
}
