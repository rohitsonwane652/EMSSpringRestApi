package com.cg.sonwane.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sonwane.ems.exceptions.UserDefinedExceptions;
import com.cg.sonwane.ems.model.Address;
import com.cg.sonwane.ems.model.Employee;
import com.cg.sonwane.ems.service.EmployeeService;

@RestController
public class AddressController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/findAddress/{id}")
	public Address findByAddress (@PathVariable int id)throws UserDefinedExceptions {
		Employee employee = employeeService.findEmployee(id);
		return employee.getAddress();
		
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public String deleteEmployeeAddress(@PathVariable int id)throws UserDefinedExceptions  {
		Employee employee = employeeService.findEmployee(id);
		employee.setAddress(null);
		employeeService.updateEmployee(employee);
		return "Employee Address deleted succesfully";
	}

}
