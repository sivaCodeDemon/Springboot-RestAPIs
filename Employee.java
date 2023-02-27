package com.infy.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private int empId;
  private String empName;
  private long empNum;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public long getEmpNum() {
	return empNum;
}
public void setEmpNum(long empNum) {
	this.empNum = empNum;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empNum=" + empNum + "]";
}
public Employee() {
	super();
}
  
}
