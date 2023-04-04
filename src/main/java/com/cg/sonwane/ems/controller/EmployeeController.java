package com.cg.sonwane.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sonwane.ems.exceptions.UserDefinedExceptions;
import com.cg.sonwane.ems.model.Employee;
import com.cg.sonwane.ems.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//To get All Employees from DB
	@GetMapping("/getAllEmployee")	
	public List<Employee> getAllEmployee(){
		return employeeService.findAllEmployee();
	}
	
	//To get a single Employee with given Id
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id) throws UserDefinedExceptions{
		Employee employee = employeeService.findEmployee(id);
		if(employee == null) {
			throw new UserDefinedExceptions("Employee with employee id "+id+" not found");
		}
		return employee;
	}
	
	//Add Employees in the DB
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		Employee newEmployee = null;
//		try {
			newEmployee = employeeService.saveEmployee(employee);
			
//		} catch (UserDefinedExceptions e) {
//			System.out.println(e.getMessage());
//		}
		return new ResponseEntity<Employee>(newEmployee,HttpStatus.CREATED);
	}
	
	//Update Existing employee info in DB
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) throws UserDefinedExceptions {
		try {
			employeeService.updateEmployee(employee);
		} catch(UserDefinedExceptions e) {
			System.out.println(e.getMessage());
		}
		return employee;
		
	}
	
	//Delete the employee data from DB
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		if(employeeService.deleteEmployeeById(id)) {
			return new ResponseEntity<String>("Employee deleted succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Employee Not found",HttpStatus.NOT_FOUND);
		}
		
	}
}
