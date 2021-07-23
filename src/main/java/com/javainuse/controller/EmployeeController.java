package com.javainuse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.exception.ResourceNotFoundException;
import com.javainuse.model.Employee;
import com.javainuse.repository.EmployeeRepository;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employee/{employeeId}")
	public List<Employee> getEmployeeByemployeeId(@PathVariable Long employeeId) {
		return employeeRepository.findByEmployeeId(employeeId);
	}

	@GetMapping("/employees")
	public Page<Employee> getQuestions(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

	@PostMapping("/employees")
	public Employee createQuestion(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employee/{employeeId}")
	public Employee updateQuestion(@PathVariable Long empId, @Valid @RequestBody Employee empRequest)
			throws ResourceNotFoundException {
		return employeeRepository.findById(empId).map(employee -> {
			employee.setName(empRequest.getName());
			employee.setAge(empRequest.getAge());
			return employeeRepository.save(employee);
		}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + empId));
	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) throws ResourceNotFoundException {
		return employeeRepository.findById(questionId).map(employee -> {
			employeeRepository.delete(employee);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id" + questionId));
	}
}
