package com.example.hammad_crud_project.repository;

import com.example.hammad_crud_project.entity.CourseEntity;
import com.example.hammad_crud_project.entity.EnrollmentEntity;
import com.example.hammad_crud_project.entity.StudentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EnrollmentRepositoryTest {

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    private StudentEntity studentEntity;
    private CourseEntity courseEntity;

    @BeforeEach
    void setUp(){
        studentRepository.deleteAll();
        courseRepository.deleteAll();
        enrollmentRepository.deleteAll();

        studentEntity = new StudentEntity();
        studentEntity.setFirstMidName("John");
        studentEntity.setLastName("Doe");
        studentEntity.setEnrollmentDate(new Date());
        studentRepository.saveAndFlush(studentEntity);


        courseEntity  = new CourseEntity();
        courseEntity.setTitle("Math");
        courseEntity.setCredits(3);
        courseRepository.saveAndFlush(courseEntity);

    }

    @Test
    @Rollback(false)
    public void testSaveEnrollment(){
        EnrollmentEntity enrollment = new EnrollmentEntity();

        enrollment.setStudentEntity(studentEntity);
        enrollment.setCourseEntity(courseEntity);
        enrollment.setGrade(75);

        EnrollmentEntity savedEnrollment = enrollmentRepository.save(enrollment);

        assertNotNull(savedEnrollment);
        assertEquals(75, savedEnrollment.getGrade());

    }

    @Test
    public void testFindById(){
        EnrollmentEntity enrollment = new EnrollmentEntity();

        enrollment.setStudentEntity(studentEntity);
        enrollment.setCourseEntity(courseEntity);
        enrollment.setGrade(60);

        EnrollmentEntity savedEnrollment = enrollmentRepository.save(enrollment);

        EnrollmentEntity foundEnrollment = enrollmentRepository.findById(savedEnrollment.getEnrollmentId()).orElse(null);

        assertNotNull(foundEnrollment);
        assertEquals(savedEnrollment.getEnrollmentId(), foundEnrollment.getEnrollmentId());
    }

    @Test
    void testFindAll(){
        EnrollmentEntity enrollmentOne = new EnrollmentEntity();
        enrollmentOne.setStudentEntity(studentEntity);
        enrollmentOne.setCourseEntity(courseEntity);
        enrollmentOne.setGrade(60);
        enrollmentRepository.save(enrollmentOne);

        EnrollmentEntity enrollmentTwo = new EnrollmentEntity();
        enrollmentTwo.setStudentEntity(studentEntity);
        enrollmentTwo.setCourseEntity(courseEntity);
        enrollmentTwo.setGrade(70);
        enrollmentRepository.save(enrollmentTwo);

        assertEquals(2, enrollmentRepository.findAll().size());

    }

    @Test
    @Rollback(false)
    void testDeleteById(){
        EnrollmentEntity enrollment = new EnrollmentEntity();
        enrollment.setStudentEntity(studentEntity);
        enrollment.setCourseEntity(courseEntity);
        enrollment.setGrade(60);
        EnrollmentEntity savedEnrollment = enrollmentRepository.save(enrollment);

        enrollmentRepository.deleteById(savedEnrollment.getEnrollmentId());

        assertNull(enrollmentRepository.findById(savedEnrollment.getEnrollmentId()).orElse(null));
    }



}
