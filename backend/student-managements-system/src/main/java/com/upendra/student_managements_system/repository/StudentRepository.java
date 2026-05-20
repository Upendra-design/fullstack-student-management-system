package com.upendra.student_managements_system.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.upendra.student_managements_system.model.Student;
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
