package com.upendra.student_managements_system.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upendra.student_managements_system.model.Student;
import com.upendra.student_managements_system.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
    StudentRepository repo;
	public Student addStudent(Student s) {
		return repo.save(s);
	}
	public List<Student> getStudents() {
		return repo.findAll();
	}
	public Student getStudent(int id) {
		return repo.findById(id).orElse(null);
	}
	public Student updateStudent(int id, Student newSt) {
		Student s=repo.findById(id).orElse(null);
		if(s!=null) {
			
			s.setName(newSt.getName());
			s.setEmail(newSt.getEmail());
			s.setCourse(newSt.getCourse());
			return repo.save(s);
		}
		return null;
	}
	
	public void deleteStudent(int id) {
		 repo.deleteById(id);
	}

}
