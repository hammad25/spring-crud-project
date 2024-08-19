package com.example.hammad_crud_project.controller;

import com.example.hammad_crud_project.service.StudentService;
import lombok.AllArgsConstructor;
import org.openapitools.api.StudentsApi;
import org.openapitools.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class StudentController implements StudentsApi {
    private final StudentService studentService;

    @Override
    public ResponseEntity<Void> createStudent(Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Void> deleteStudent(Integer id) {
        studentService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        var allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @Override
    public ResponseEntity<Student> getStudentById(Integer id) {
        var studentById = studentService.getStudentById(id);
        return ResponseEntity.ok(studentById);
    }

    @Override
    public ResponseEntity<Void> updateStudent(Integer id, Student student) {
        var updated = studentService.updateStudent(id, student);
        if(updated){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
