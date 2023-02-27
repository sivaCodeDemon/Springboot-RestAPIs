package com.infy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.demo.Entity.Employee;
import com.infy.demo.Repository.EmployeeRepo;

@RestController
@RequestMapping(name = "employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepo employeerepo;
	@PostMapping("/api/employee")
  public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
	return  new ResponseEntity<>(employeerepo.save(employee),HttpStatus.CREATED);
	}
	@GetMapping("/api/employees")
	  public ResponseEntity<List<Employee>> getEmployees() {
		  return new ResponseEntity<>(employeerepo.findAll(),HttpStatus.OK);
		  
	  }
	@GetMapping("/api/employee/{id}")
	  public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
		Optional<Employee> employee= employeerepo.findById(id);
		if(employee.isPresent()) {
			
			return new ResponseEntity<>(employee.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	  }
	@PutMapping("/api/employee/{id}")
	  public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employe) {
		Optional<Employee> employee= employeerepo.findById(id);
		if(employee.isPresent()) {
			employee.get().setEmpName(employe.getEmpName());
			employee.get().setEmpNum(employe.getEmpNum());
			return new ResponseEntity<>(employeerepo.save(employee.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	  }
	@DeleteMapping("/api/employee/{id}")
	  public ResponseEntity<Void> DeleteEmployee(@PathVariable long id) {
		Optional<Employee> employee= employeerepo.findById(id);
		if(employee.isPresent()) {
			employeerepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
  }

