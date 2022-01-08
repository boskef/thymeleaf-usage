package com.springboot.thymeleafusage.repository;

import com.springboot.thymeleafusage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    //getting all of crud methods with this JpaRepository Super Interface...
}
