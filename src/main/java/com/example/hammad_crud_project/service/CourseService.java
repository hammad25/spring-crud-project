package com.example.hammad_crud_project.service;

import com.example.hammad_crud_project.entity.CourseEntity;
import com.example.hammad_crud_project.mapper.CourseEntityMapper;
import com.example.hammad_crud_project.mapper.CourseMapper;
import com.example.hammad_crud_project.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.openapitools.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CourseEntityMapper courseEntityMapper;

    public List<Course> getAllCourses(){
        var allCourses = courseRepository.findAll();
        return allCourses.stream().map(courseMapper::map).toList();

    }

    public Course getCourseById(int id) {
        var courseById = courseRepository.findById(id);
        return courseById.map(courseMapper::map).orElse(null);
    }

    public CourseEntity saveCourse(Course course) {
        CourseEntity courseEntity = courseEntityMapper.map(course);
        return courseRepository.save(courseEntity);
    }

    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    //explain the code below
    public boolean updateCourse(int id, Course course){
        var courseEntity = courseRepository.findById(id).orElse(null);
        if(courseEntity != null){
            courseEntity = courseEntityMapper.map(course);
            courseEntity.setCourseId(id);
            courseRepository.save(courseEntity);
            return true;
        }
        return false;
    }

}
