package com.application03.studentmvc.service;

import com.application03.studentmvc.dao.StudentRepo;
import com.application03.studentmvc.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements  StudentService{

    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }
    @Override
    public List<StudentEntity> select() {
        return studentRepo.findAll();
    }

    @Override
    public StudentEntity findById(int id) {
        Optional<StudentEntity> optional=studentRepo.findById(id);
        StudentEntity student=optional.get();
        return student;
    }

    @Override
    public void save(StudentEntity student) {
        studentRepo.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }
}
