package com.cg.sonwane.ems.validators;

import com.cg.sonwane.ems.model.Employee;

public class EmployeeValidator {
	
	public String validateEmployee(Employee employee) {
		if(employee.getName().isEmpty()) {
			return "Employee could not be empty";
		}
		else if(employee.getDepartment().isEmpty()) {
			return "Employee Department should be not valid";
		}
		return null;
	}
}
