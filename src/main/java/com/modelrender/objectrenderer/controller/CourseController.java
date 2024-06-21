package com.modelrender.objectrenderer.controller;

import com.modelrender.objectrenderer.entity.Course;
import com.modelrender.objectrenderer.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/insertCourse")
    public Course insertCourse(@RequestBody Course course)
    {
        return courseService.addCourse(course);
    }

    @GetMapping("/getAllCourse")
    public List<Course> getCourses()
    {
        return courseService.findAllCourse();
    }


}
