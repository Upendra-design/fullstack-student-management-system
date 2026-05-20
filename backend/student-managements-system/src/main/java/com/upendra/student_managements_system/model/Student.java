package com.upendra.student_managements_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	  private int id;
	  private String name;
	  private String email;
	   private String course;
	   //setters
	   public void setId(int id) {
			this.id = id;
		 }
	   public void setName(String name) {
			this.name = name;
		  }
	   public void setEmail(String email) {
		this.email = email;
	   }	   
	   public void setCourse(String course) {
		this.course = course;
	   }
	   //getters
	   public int getId() {
			return id;
		   }
	   public String getName() {
			return name;
		   }
	   public String getEmail() {
			return email;
		   }
	   public String getCourse() {
			return course;
		   }
}
