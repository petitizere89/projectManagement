package com.izere.pma.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.izere.pma.entities.Employee;

//@Service without @Service annotation, this class wont be scanned by SpringBoot
public class EmployeeService {

// Field Injection
  @Autowired
  Employee empServ;
  

//  Constructor Injection. Does not need @Autowired annotation 
//  public EmployeeService(Employee empServ) {
//	  super();
//	  this.empServ=empServ;
//  }
//
//  @Autowired //Setter Injection, need @Autowried to work
//  public void setEmpServ(Employee empServ) {
//	this.empServ = empServ;
//  }
//  
  
   // SELECT * FROM employee where salary > 5000;
   // SELECT * FROM emplyee where
}
