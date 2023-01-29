package com.prowings.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import com.prowings.model.Candidate;
import com.prowings.model.Student;

@Service
public class ConsumerService {
	
	RestTemplate template = new RestTemplate();
	@Value("${baseUrl}")
	String url;
	
	public Student callStudentById(int id) throws URISyntaxException
	{
		String finalUrl = url+id;		
		URI uri = new URI(finalUrl);
		 return template.getForObject(uri, Student.class);
	}
    @ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Student> callSaveStudent(Candidate std) throws RestClientException, URISyntaxException {
		
		ResponseEntity<Student> response = template.postForEntity(new URI(url), std, Student.class);
		
		ResponseEntity<Student> response2 = new ResponseEntity<Student>(response.getBody(), HttpStatus.CREATED); 
		return response2;
	}

}
