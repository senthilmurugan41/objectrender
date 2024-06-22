package com.modelrender.objectrenderer.service;

import com.modelrender.objectrenderer.entity.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);

    List<Course> findAllCourse();

    Course findCourseByName(String name);

    Course updateCourseName(String oldName, String newName);

    void deleteCourseByName(String name);

}
