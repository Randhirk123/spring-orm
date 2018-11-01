package com.randhir.student.dao;

import java.util.List;

import com.randhir.student.model.Student;

public interface StudentDao {
	public int save(Student st);
	public int update(Student st);
	public int delete(Student st);
	public Student getStudentById(int id);
	public List<Student> getAllStudent();
	
	public Student getStudentByEmailAndPassword(String email, String password);
	
	
	
	
	

}
