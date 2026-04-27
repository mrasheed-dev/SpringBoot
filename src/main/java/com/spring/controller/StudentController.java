package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

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
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable int id)
	{
		Optional<Student> student = studentRepository.findById(id);
		return student.orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id)
	{
		studentRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Student updateById(@PathVariable int id, @RequestBody Student student)
	{
		Optional<Student> existingStudent = studentRepository.findById(id);
		if(existingStudent.isPresent())
		{
			Student s = existingStudent.get();
			s.setName(student.getName());
			s.setEmail(student.getEmail());
			return studentRepository.save(s);
		}
		else
		{
			return null;
		}
		
	}
}
