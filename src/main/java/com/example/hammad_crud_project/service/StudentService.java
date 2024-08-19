package com.example.hammad_crud_project.service;

import com.example.hammad_crud_project.entity.StudentEntity;
import com.example.hammad_crud_project.mapper.StudentEntityMapper;
import com.example.hammad_crud_project.mapper.StudentMapper;
import com.example.hammad_crud_project.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.openapitools.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {


    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentEntityMapper studentEntityMapper;

    public List<Student> getAllStudents(){
        var allStudents = studentRepository.findAll();
        return allStudents.stream().map(studentMapper::map).toList();
    }

    public Student getStudentById(int id){
        var studentById = studentRepository.findById(id);
        return studentById.map(studentMapper::map).orElse(null);
    }

    public StudentEntity saveStudent(Student student){
        StudentEntity studentEntity = studentEntityMapper.map(student);
        return studentRepository.save(studentEntity);
    }

    public void deleteById(int id){
        studentRepository.deleteById(id);
    }

    public boolean updateStudent(int id, Student student){
        var studentEntity = studentRepository.findById(id).orElse(null);
        if(studentEntity != null){
            studentEntity = studentEntityMapper.map(student);
            studentEntity.setId(id);
            studentRepository.save(studentEntity);
            return true;
        }
        return false;
    }

}
