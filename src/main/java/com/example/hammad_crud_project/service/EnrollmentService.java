package com.example.hammad_crud_project.service;

import com.example.hammad_crud_project.entity.EnrollmentEntity;
import com.example.hammad_crud_project.mapper.EnrollmentEntityMapper;
import com.example.hammad_crud_project.mapper.EnrollmentMapper;
import com.example.hammad_crud_project.repository.EnrollmentRepository;
import org.openapitools.model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private EnrollmentEntityMapper enrollmentEntityMapper;
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    public List<Enrollment> getAllEnrollments() {
        var allEnrollments = enrollmentRepository.findAll();
        return allEnrollments.stream().map(enrollmentMapper::map).toList();
    }

    public Enrollment getEnrollmentById(int id) {
        var enrollmentById =  enrollmentRepository.findById(id);
        return enrollmentById.map(enrollmentMapper::map).orElse(null);
    }

    public EnrollmentEntity saveEnrollment(Enrollment enrollment) {
        EnrollmentEntity enrollmentEntity = enrollmentEntityMapper.map(enrollment);
        return enrollmentRepository.save(enrollmentEntity);
    }

    public boolean deleteById(int id) {
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateEnrollment(int id, Enrollment enrollment){
        var enrollmentEntity = enrollmentRepository.findById(id).orElse(null);
        if(enrollmentEntity != null){
            enrollmentEntity = enrollmentEntityMapper.map(enrollment);
            enrollmentEntity.setEnrollmentId(id);
            enrollmentRepository.save(enrollmentEntity);
            return true;
        }
        return false;
    }

}