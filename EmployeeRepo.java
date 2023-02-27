package com.infy.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.demo.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

};
