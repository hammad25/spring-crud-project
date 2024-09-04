package com.example.hammad_crud_project.mapper;

import org.junit.jupiter.api.Test;
import org.openapitools.model.Enrollment;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnrollmentEntityMapperTest {
    private final EnrollmentEntityMapper enrollmentEntityMapper = new EnrollmentEntityMapperImpl();

    @Test
    void testMap(){
        var enrollment = new Enrollment();
        enrollment.setGrade(85);
        enrollment.setEnrollmentId(1);

        var result = enrollmentEntityMapper.map(enrollment);
        assertEquals(enrollment.getGrade(), result.getGrade());
    }
}
