package com.example.hammad_crud_project.controller;

import com.example.hammad_crud_project.entity.CourseEntity;
import com.example.hammad_crud_project.entity.EnrollmentEntity;
import com.example.hammad_crud_project.entity.StudentEntity;
import com.example.hammad_crud_project.mapper.EnrollmentEntityMapper;
import com.example.hammad_crud_project.mapper.EnrollmentMapper;
import com.example.hammad_crud_project.service.CourseService;
import com.example.hammad_crud_project.service.EnrollmentService;
import com.example.hammad_crud_project.service.StudentService;
import lombok.AllArgsConstructor;
import org.openapitools.api.EnrollmentsApi;
import org.openapitools.model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController implements EnrollmentsApi {

    @Autowired
    private EnrollmentService enrolmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;



    @Override
    public ResponseEntity<Void> createEnrollment(Enrollment enrollment) {

//        Optional<StudentEntity> studentEntity = studentService.getStudentById(enrollment.getStudentId());
//        Optional<CourseEntity> courseEntity = courseService.getCourseById(enrollment.getCourseId());
//
//        if (!studentEntity.isPresent() || !courseEntity.isPresent()) {
//            return ResponseEntity.status(404).build();
//        }
//
//        EnrollmentEntity enrollmentEntity = enrollmentEntityMapper.map(enrollment);
//        enrollmentEntity.setStudentEntity(studentEntity.get());
//        enrollmentEntity.setCourseEntity(courseEntity.get());
//        enrolmentService.saveEnrollment(enrollmentEntity);
//        return ResponseEntity.status(201).build();

        enrolmentService.saveEnrollment(enrollment);
        return ResponseEntity.status(201).build();

    }

    @Override
    public ResponseEntity<Void> deleteEnrollment(Integer id) {
        enrolmentService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @Override
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        var allEnrollments = enrolmentService.getAllEnrollments();
        return ResponseEntity.ok(allEnrollments);
    }

    @Override
    public ResponseEntity<Enrollment> getEnrollmentById(Integer id) {
        var enrollmentById = enrolmentService.getEnrollmentById(id);
        return ResponseEntity.ok(enrollmentById);
    }

    @Override
    public ResponseEntity<Void> updateEnrollment(Integer id, Enrollment enrollment) {
        var updatedEnrollment = enrolmentService.updateEnrollment(id, enrollment);
        if(updatedEnrollment){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
