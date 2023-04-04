package com.cg.sonwane.ems.service;

import java.util.List;

import com.cg.sonwane.ems.exceptions.UserDefinedExceptions;
import com.cg.sonwane.ems.model.Employee;

public interface EmployeeService  {
	public List<Employee> findAllEmployee();
	public Employee findEmployee(Integer id) throws UserDefinedExceptions;
	public Employee saveEmployee(Employee employee) ;
	public Boolean deleteEmployeeById(Integer id);
	public Employee updateEmployee(Employee employee) throws UserDefinedExceptions;
	
	
}
