package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Student;
import com.spring.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController
{
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/save")
	public Student save(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
	
	@GetMapping("/get")
	public List<Student> get()
	{
		return studentRepository.findAll();
	}
}
