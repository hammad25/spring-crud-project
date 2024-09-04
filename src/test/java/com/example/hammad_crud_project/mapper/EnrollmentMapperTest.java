package com.example.hammad_crud_project.mapper;

import com.example.hammad_crud_project.entity.EnrollmentEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnrollmentMapperTest {

    private final EnrollmentMapper enrollmentMapper = new EnrollmentMapperImpl();


    @Test
    void testMap(){
        var enrollmentEntity = new EnrollmentEntity();
        enrollmentEntity.setGrade(85);
        enrollmentEntity.setEnrollmentId(1);

        var result = enrollmentMapper.map(enrollmentEntity);
        assertEquals(enrollmentEntity.getGrade(), result.getGrade());
    }
}
