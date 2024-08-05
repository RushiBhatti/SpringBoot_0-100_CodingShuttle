package com.learningspring.rushi.week2homework.Week2Homework.repositories;

import com.learningspring.rushi.week2homework.Week2Homework.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
