package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController
{
	@GetMapping("/")
	public String home()
	{
		return "Spring Boot Application";
	}
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to Spring Boot Application";
	}
	
	@GetMapping("/user/{name}")
	public String getUser(@PathVariable String name)
	{
		return "hello " + name;
	}
	
	@GetMapping("/{id}")
	public String add(@PathVariable String emp_id)
	{
		
		return  emp_id;
}
	
}
