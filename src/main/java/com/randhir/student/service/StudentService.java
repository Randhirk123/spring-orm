package com.randhir.student.service;

import java.util.List;

import com.randhir.student.model.Student;

public interface StudentService {
	public boolean saveStudent(Student st);

	public int updateStudent(Student st);

	public int deleteStudent(Student st);

	public Student getById(int id);

	public List<Student> getAllStudent();

	public Student studentValidate(String email, String password);
	
	public Student passwordCnfrmPassValidate(String password, String cnfrmPass);

}
