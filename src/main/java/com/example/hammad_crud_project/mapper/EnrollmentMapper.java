package com.example.hammad_crud_project.mapper;

import com.example.hammad_crud_project.entity.EnrollmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.Enrollment;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    @Mapping(source="courseEntity.courseId", target="courseId")
    @Mapping(source="studentEntity.studentId", target="studentId")
    Enrollment map(EnrollmentEntity enrollmentEntity);
}
