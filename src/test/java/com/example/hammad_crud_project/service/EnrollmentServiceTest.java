package com.example.hammad_crud_project.service;

import com.example.hammad_crud_project.entity.CourseEntity;
import com.example.hammad_crud_project.entity.EnrollmentEntity;
import com.example.hammad_crud_project.entity.StudentEntity;
import com.example.hammad_crud_project.mapper.EnrollmentEntityMapper;
import com.example.hammad_crud_project.mapper.EnrollmentMapper;
import com.example.hammad_crud_project.repository.CourseRepository;
import com.example.hammad_crud_project.repository.EnrollmentRepository;
import com.example.hammad_crud_project.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.model.Enrollment;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EnrollmentServiceTest {

    @Mock
    private EnrollmentRepository enrollmentRepository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private CourseRepository courseRepository;
    @Mock
    private EnrollmentEntityMapper enrollmentEntityMapper;
    @Mock
    private EnrollmentMapper enrollmentMapper;

    @InjectMocks
    private EnrollmentService enrollmentService;

    private StudentEntity studentEntity;
    private CourseEntity courseEntity;
    private EnrollmentEntity enrollmentEntity;
    private Enrollment enrollment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        studentEntity = new StudentEntity();
        studentEntity.setFirstMidName("John");
        studentEntity.setLastName("Doe");
        studentEntity.setEnrollmentDate(new Date());
        studentEntity.setId(1);

        courseEntity = new CourseEntity();
        courseEntity.setTitle("Math");
        courseEntity.setCredits(3);
        courseEntity.setCourseId(1);

        enrollmentEntity = new EnrollmentEntity();
        enrollmentEntity.setStudentEntity(studentEntity);
        enrollmentEntity.setCourseEntity(courseEntity);
        enrollmentEntity.setGrade(85);

        enrollment = new Enrollment();
        enrollment.setStudentId(1);
        enrollment.setCourseId(1);
        enrollment.setGrade(85);
    }

    @Test
    void testGetAllEnrollments() {
        when(enrollmentRepository.findAll()).thenReturn(List.of(enrollmentEntity));
        when(enrollmentMapper.map(enrollmentEntity)).thenReturn(enrollment);

        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();

        assertNotNull(enrollments);
        assertEquals(1, enrollments.size());
        verify(enrollmentRepository, times(1)).findAll();
        verify(enrollmentMapper, times(1)).map(enrollmentEntity);
    }

    @Test
    void testGetEnrollmentById() {
        when(enrollmentRepository.findById(1)).thenReturn(Optional.of(enrollmentEntity));
        when(enrollmentMapper.map(enrollmentEntity)).thenReturn(enrollment);

        Enrollment foundEnrollment = enrollmentService.getEnrollmentById(1);

        assertNotNull(foundEnrollment);
        assertEquals(1, foundEnrollment.getStudentId());
        verify(enrollmentRepository, times(1)).findById(1);
        verify(enrollmentMapper, times(1)).map(enrollmentEntity);
    }

    @Test
    void testSaveEnrollment() {
        when(enrollmentEntityMapper.map(enrollment)).thenReturn(enrollmentEntity);
        when(enrollmentRepository.save(enrollmentEntity)).thenReturn(enrollmentEntity);

        EnrollmentEntity savedEnrollment = enrollmentService.saveEnrollment(enrollment);

        assertNotNull(savedEnrollment);
        assertEquals(85, savedEnrollment.getGrade());
        verify(enrollmentEntityMapper, times(1)).map(enrollment);
        verify(enrollmentRepository, times(1)).save(enrollmentEntity);
    }

    @Test
    void testDeleteById() {
        when(enrollmentRepository.existsById(1)).thenReturn(true);

        boolean isDeleted = enrollmentService.deleteById(1);

        assertTrue(isDeleted);
        verify(enrollmentRepository, times(1)).existsById(1);
        verify(enrollmentRepository, times(1)).deleteById(1);
    }

    @Test
    void testUpdateEnrollment() {
        when(enrollmentRepository.findById(1)).thenReturn(Optional.of(enrollmentEntity));
        when(enrollmentEntityMapper.map(enrollment)).thenReturn(enrollmentEntity);
        when(enrollmentRepository.save(enrollmentEntity)).thenReturn(enrollmentEntity);

        boolean isUpdated = enrollmentService.updateEnrollment(1, enrollment);

        assertTrue(isUpdated);
        verify(enrollmentRepository, times(1)).findById(1);
        verify(enrollmentEntityMapper, times(1)).map(enrollment);
        verify(enrollmentRepository, times(1)).save(enrollmentEntity);
    }
}