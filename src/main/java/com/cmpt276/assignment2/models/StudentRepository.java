package com.cmpt276.assignment2.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student ,Integer> {
    List<Student> findByUid(int uid);
    List<Student> findByName(String name);
    List<Student> deleteByUid(int uid);
}
