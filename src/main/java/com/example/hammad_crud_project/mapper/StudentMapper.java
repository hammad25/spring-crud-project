package com.example.hammad_crud_project.mapper;

import com.example.hammad_crud_project.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "firstMidName", source = "firstMidName")
    @Mapping(target = "enrollmentDate", source = "enrollmentDate")
    Student map(StudentEntity studentEntity);

}

