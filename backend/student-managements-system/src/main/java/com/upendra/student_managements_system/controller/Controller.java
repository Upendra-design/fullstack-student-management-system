package com.upendra.student_managements_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.student_managements_system.model.Student;
import com.upendra.student_managements_system.service.StudentService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("students")
public class Controller {
    @Autowired
    StudentService service;
    @PostMapping("/add")
	public Student addStudent(@RequestBody Student s) {
		return service.addStudent(s);
	}
    @GetMapping("/allStudents")
    public List<Student> getStudents(){
    	return service.getStudents();
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
    	return service.getStudent(id);
    }
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id,@RequestBody Student s) {
		return service.updateStudent(id,s);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
				service.deleteStudent(id);
		return "Student deleted successfully";
	}
	
}
