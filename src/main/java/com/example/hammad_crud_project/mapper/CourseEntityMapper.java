package com.example.hammad_crud_project.mapper;

import com.example.hammad_crud_project.entity.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.Course;

@Mapper(componentModel = "spring")
public interface CourseEntityMapper {

    @Mapping(target = "courseId", ignore = true)
    @Mapping(target = "title", source = "title")
    @Mapping(target = "credits", source = "credits")
    CourseEntity map(Course course);

//    @Mapping(target = "courseId", source = "courseId")
//    @Mapping(target = "title", source = "title")
//    @Mapping(target = "credits", source = "credits")
//    Course entityToApi(CourseEntity courseEntity);
}