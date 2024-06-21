package com.modelrender.objectrenderer.service.impl;

import com.modelrender.objectrenderer.entity.Course;
import com.modelrender.objectrenderer.repo.CourseRepo;
import com.modelrender.objectrenderer.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> findAllCourse()
    {
        return courseRepo.findAll();
    }
}
