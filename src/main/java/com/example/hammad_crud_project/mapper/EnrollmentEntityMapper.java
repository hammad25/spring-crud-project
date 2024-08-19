package com.example.hammad_crud_project.mapper;


import com.example.hammad_crud_project.entity.EnrollmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.Enrollment;

@Mapper (componentModel = "spring")
public interface EnrollmentEntityMapper {
    @Mapping(source = "id", target = "studentEntity.id")
    @Mapping(source = "courseId", target = "courseEntity.courseId")
    EnrollmentEntity map(Enrollment enrollment);
}
