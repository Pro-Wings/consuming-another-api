package com.prowings.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.model.Candidate;
import com.prowings.model.Student;
import com.prowings.service.ConsumerService;


@RestController
@RequestMapping("/api-consumer")
public class StudentCrudInvokerController {
	@Autowired
	ConsumerService service;
	
	@GetMapping("/students/{id}")
	public Student callGetStudentById(@PathVariable("id") int id) throws URISyntaxException
	{
		return service.callStudentById(id);
	}
 
	@PostMapping("/students")
	public ResponseEntity<Student> callSaveStudent(@RequestBody Candidate std ) throws URISyntaxException
	{
		return service.callSaveStudent(std);
	}

}
