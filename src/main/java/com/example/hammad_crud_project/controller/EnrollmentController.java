package com.example.hammad_crud_project.controller;

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

@AllArgsConstructor
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController implements EnrollmentsApi {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;



    @Override
    public ResponseEntity<Void> createEnrollment(Enrollment enrollment) {
        enrollmentService.saveEnrollment(enrollment);
        return ResponseEntity.status(201).build();

    }

    @Override
    public ResponseEntity<Void> deleteEnrollment(Integer id) {
        enrollmentService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @Override
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        var allEnrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(allEnrollments);
    }

    @Override
    public ResponseEntity<Enrollment> getEnrollmentById(Integer id) {
        var enrollmentById = enrollmentService.getEnrollmentById(id);
        return ResponseEntity.ok(enrollmentById);
    }

    @Override
    public ResponseEntity<Void> updateEnrollment(Integer id, Enrollment enrollment) {
        var updatedEnrollment = enrollmentService.updateEnrollment(id, enrollment);
        if(updatedEnrollment){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
