package com.example.hammad_crud_project.controller;


import com.example.hammad_crud_project.mapper.CourseEntityMapper;
import com.example.hammad_crud_project.mapper.CourseMapper;
import com.example.hammad_crud_project.service.CourseService;
import lombok.AllArgsConstructor;
import org.openapitools.api.CoursesApi;
import org.openapitools.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController implements CoursesApi {

    @Autowired
    private final CourseService courseService;
    @Autowired
    private CourseEntityMapper courseEntityMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public ResponseEntity<Void> createCourse(Course course) {
        courseService.saveCourse(course);
        return ResponseEntity.status(201).build() ; //created
    }

    @Override
    public ResponseEntity<Void> deleteCourse(Integer id) {
        courseService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @Override
    public ResponseEntity<List<Course>> getAllCourses() {
        var allCourses = courseService.getAllCourses();
        return ResponseEntity.ok(allCourses);
    }

    @Override
    public ResponseEntity<Course> getCourseById(Integer id) {
        var courseById = courseService.getCourseById(id);
        return ResponseEntity.ok(courseById);
    }

    @Override
    public ResponseEntity<Void> updateCourse(Integer id, Course course) {
        var updated = courseService.updateCourse(id, course);
        if(updated){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
