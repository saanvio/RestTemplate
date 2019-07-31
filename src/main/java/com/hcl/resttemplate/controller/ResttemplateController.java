package com.hcl.resttemplate.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.resttemplate.dto.ApplicationResponse;
import com.hcl.resttemplate.dto.EmployeeDto;

@RestController
@RequestMapping("/employee")
public class ResttemplateController {
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/add")
	public ApplicationResponse addEmployee(@RequestBody EmployeeDto employeeDto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<EmployeeDto> entity = new HttpEntity<>(employeeDto, httpHeaders);
		ApplicationResponse res = restTemplate
				.exchange("http://localhost:9090/employee/add", HttpMethod.POST, entity, ApplicationResponse.class).getBody();
		return res;
	}

}
