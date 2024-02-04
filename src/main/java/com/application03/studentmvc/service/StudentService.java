package com.application03.studentmvc.service;

import com.application03.studentmvc.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    List<StudentEntity> select();

    StudentEntity findById(int id);
    void save(StudentEntity student);

    void delete(int id);
}
