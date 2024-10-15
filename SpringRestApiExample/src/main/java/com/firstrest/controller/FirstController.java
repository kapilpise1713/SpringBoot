package com.firstrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstrest.model.Student;
import com.firstrest.model.Trainer;

@RestController
public class FirstController {
	
	//@RequestMapping(method=RequestMethod.GET,path="/first")
	@GetMapping("/first")
	public String display() {
		return "welcome all to SpringBoot Rest API!";
	}
	
	@GetMapping("/student")
	public Student info() {
		Student stud1 = new Student("Shreya",22);
		return stud1;	
	}
	
	
	
	@GetMapping("/trainer/{name}")
	public Trainer train(@PathVariable String name) {
		
		return new Trainer(name);
	}
	
	@GetMapping("/student/{name}/age/{age}")
	public Student stud(@PathVariable String name, @PathVariable int age) {
		return new Student(name, age);
	}
	

}
