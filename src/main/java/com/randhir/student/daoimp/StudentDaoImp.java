package com.randhir.student.daoimp;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.randhir.student.dao.StudentDao;
import com.randhir.student.model.Student;
@Repository("studentDao")
public class StudentDaoImp implements StudentDao {
@Autowired
private HibernateTemplate hibernateTemplate;
public void setHt(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}
public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}

	@Override
	@Transactional
	public int save(Student st) {
		System.out.println("i m trying to invoke");
		System.out.println(hibernateTemplate);
		int status=(int) hibernateTemplate.save(st);
		if(status>=0)
		return  status;
		else
			return -1;
	}

	@Override
	@Transactional
	public int update(Student st) {
		int status=0;
	hibernateTemplate.update(st);
	status=1;
	return status;
	
	}

	@Override
	@Transactional
	public int delete(Student st) {
		int status=0;
		hibernateTemplate.delete(st);
		status=1;
		return status;
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		
		Student st= hibernateTemplate.get(Student.class, id);
		return st;
	}

	@Override
	@Transactional
	public List<Student> getAllStudent() {
		List<Student> list=hibernateTemplate.loadAll(Student.class);
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Student getStudentByEmailAndPassword(String email, String password) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Student.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<Student> list =(List<Student>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(list!=null && list.size()>0)
		{
			return list.get(0);
		}
		else
			return null;
	}

}
