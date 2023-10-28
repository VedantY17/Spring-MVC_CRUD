package com.jsp.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.student.dto.Student;
import com.jsp.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/createstudent")
	public ModelAndView createStudent() {

		ModelAndView modelAndView = new ModelAndView("studentform.jsp");
		modelAndView.addObject("student1", new Student());

		return modelAndView;
	}

	@RequestMapping("/studentadd")
	public ModelAndView studentAdd(@ModelAttribute Student student) {

		ModelAndView modelAndView = new ModelAndView("home.jsp");
		studentService.saveStudent(student);
		modelAndView.addObject("saved", student.getName() + " has been saved");

		return modelAndView;
	}

	@RequestMapping("/viewallStudents")
	public ModelAndView getAllStudents() {

		ModelAndView modelAndView = new ModelAndView("viewall.jsp");
		List<Student> students = studentService.getAllStudents();
		modelAndView.addObject("students", students);

		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteStudentById(@RequestParam(name = "id") int id) {

		ModelAndView modelAndView = new ModelAndView("home.jsp");
		studentService.deleteStudentById(id);
		modelAndView.addObject("saved", "Student with ID " + id + " deleted");

		return modelAndView;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateStudentById() {
		
		ModelAndView modelAndView = new ModelAndView("updatestudentform.jsp");
		modelAndView.addObject("studentupdate", new Student());
		
		return modelAndView;	
	}
	
	@RequestMapping("/updatestudent")
	public ModelAndView finalupdate(@ModelAttribute Student student) {
		
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		studentService.updateStudentById(student.getId(), student);
		modelAndView.addObject("saved", student.getId()+" has been updated");
		
		return modelAndView;		
	}

}
