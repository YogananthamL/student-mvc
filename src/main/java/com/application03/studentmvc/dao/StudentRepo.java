package com.application03.studentmvc.dao;

import com.application03.studentmvc.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {

}
