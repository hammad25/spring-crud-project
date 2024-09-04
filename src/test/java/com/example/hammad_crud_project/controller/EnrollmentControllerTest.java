package com.example.hammad_crud_project.controller;

import com.example.hammad_crud_project.entity.EnrollmentEntity;
import com.example.hammad_crud_project.service.CourseService;
import com.example.hammad_crud_project.service.EnrollmentService;
import com.example.hammad_crud_project.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.openapitools.model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EnrollmentController.class)
public class EnrollmentControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnrollmentService enrollmentService;

    @MockBean
    private StudentService studentService;

    @MockBean
    private CourseService courseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateEnrollment() throws Exception {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(1);
        enrollment.setCourseId(1);
        enrollment.setGrade(85);

        when(enrollmentService.saveEnrollment(enrollment)).thenReturn(new EnrollmentEntity());

        mockMvc.perform(post("/api/enrollments/enrollments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(enrollment)))
                .andExpect(status().isCreated());
    }


    @Test
    void testDeleteEnrollment() throws Exception {
        when(enrollmentService.deleteById(1)).thenReturn(true);

        mockMvc.perform(delete("/api/enrollments/enrollments/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetAllEnrollments() throws Exception {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(1);
        enrollment.setCourseId(1);
        enrollment.setGrade(90);

        List<Enrollment> allEnrollments = Collections.singletonList(enrollment);
        given(enrollmentService.getAllEnrollments()).willReturn(allEnrollments);

        mockMvc.perform(get("/api/enrollments/enrollments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].studentId").value(1))
                .andExpect(jsonPath("$[0].courseId").value(1))
                .andExpect(jsonPath("$[0].grade").value(90));

    }

    @Test
    void testGetEnrollmentById() throws Exception {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(1);
        enrollment.setCourseId(1);
        enrollment.setGrade(65);

        given(enrollmentService.getEnrollmentById(anyInt())).willReturn(enrollment);

        mockMvc.perform(get("/api/enrollments/enrollments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentId").value(1))
                .andExpect(jsonPath("$.courseId").value(1))
                .andExpect(jsonPath("$.grade").value(65));
    }

    @Test
    void testUpdateEnrollment() throws Exception{
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(1);
        enrollment.setCourseId(1);
        enrollment.setGrade(90);

        given(enrollmentService.updateEnrollment(anyInt(), any(Enrollment.class))).willReturn(true);

        mockMvc.perform(put("/api/enrollments/enrollments/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(enrollment)))
                .andExpect(status().isNoContent());
    }

}