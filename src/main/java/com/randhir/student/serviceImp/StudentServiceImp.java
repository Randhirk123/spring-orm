package com.randhir.student.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randhir.student.dao.StudentDao;
import com.randhir.student.model.Student;
import com.randhir.student.service.StudentService;

@Service("studentService")
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentDao sdao;

	public void setSdao(StudentDao sdao) {
		this.sdao = sdao;
	}

	@Override
	public boolean saveStudent(Student st) {
		boolean check = false;
		int status = sdao.save(st);
		if (status >= 0) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	@Override
	public int updateStudent(Student st) {

		return sdao.update(st);
	}

	@Override
	public int deleteStudent(Student st) {

		return sdao.save(st);
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return sdao.getStudentById(id);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return sdao.getAllStudent();
	}

	@Override
	public Student studentValidate(String email, String password) {
		Student student = sdao.getStudentByEmailAndPassword(email, password);
		return student;
	}

	@Override
	public Student passwordCnfrmPassValidate(String password, String cnfrmPass) {
		
		return null;
	}

}
