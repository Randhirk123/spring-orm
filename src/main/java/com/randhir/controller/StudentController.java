package com.randhir.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.randhir.student.model.Student;
import com.randhir.student.model.StudentLogin;
import com.randhir.student.service.StudentService;

@Controller

public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("studentLogin", new StudentLogin());
		return "login";
	}

	@RequestMapping(value = "/loginSuccess", method = RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("studentLogin") StudentLogin studentLogin,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("login");
		}

		ModelAndView model = new ModelAndView("service");
		Student student = studentService.studentValidate(studentLogin.getEmail(), studentLogin.getPassword());
		if (student != null) {
			model.addObject("student", student);
		} else {
			model = new ModelAndView("notFound");
		}

		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("student", new Student());
		return "register";
	}

	@RequestMapping(value = "/registerSuccess")
	public ModelAndView registerSuccess(@ModelAttribute("student") Student student, BindingResult result) {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			return new ModelAndView("register");
		}
		
		boolean validate = studentService.saveStudent(student);
		if (validate) {
			mav = new ModelAndView("welcome");
			mav.addObject("student", student);
		} else {
			mav = new ModelAndView("error");
		}

		return mav;
	}

	@ModelAttribute

	public void header(Model model) {
		model.addAttribute("header1", "welcome to my technology");
		List<String> branch = new ArrayList<>();
		branch.add("Computer science");
		branch.add("Information Technology");
		branch.add("Civil");
		branch.add("Mechanical");
		branch.add("Electronices Engineers");
		branch.add("others");

		List<String> country = new ArrayList<>();
		country.add("India");
		country.add("Pakistan");
		country.add("USA");
		country.add("Canada");
		country.add("Japan");
		country.add("Austrailia");
		country.add("UK");
		country.add("France");
		country.add("others");

		model.addAttribute("branchList", branch);
		model.addAttribute("countryList", country);

	}

}
