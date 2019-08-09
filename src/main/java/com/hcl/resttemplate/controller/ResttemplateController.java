package com.hcl.resttemplate.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hcl.resttemplate.dto.ADto;
import com.hcl.resttemplate.dto.ApplicationResponse;
import com.hcl.resttemplate.dto.EmployeeDto;

@RestController
@RequestMapping("/restEmployee")
public class ResttemplateController {
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/create")
	public ResponseEntity<ApplicationResponse> addEmployee(@RequestBody EmployeeDto employeeDto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<EmployeeDto> entity = new HttpEntity<>(employeeDto, httpHeaders);
		ApplicationResponse res = new ApplicationResponse();
		try {
			res = restTemplate.exchange(new URI("http://localhost:9090/employee/employee/add"), HttpMethod.POST, entity,
					ApplicationResponse.class).getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ApplicationResponse>(res, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<ADto> getPrice() {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<ADto> entity = new HttpEntity<ADto>(httpHeaders);
		ADto adto = new ADto();
		adto = restTemplate
				.exchange("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=300135.SZ&apikey=CY1GA7PFLT6L8FAZ",
						HttpMethod.GET, entity, ADto.class)
				.getBody();
		return new ResponseEntity<ADto>(adto, HttpStatus.OK);
	}

}
