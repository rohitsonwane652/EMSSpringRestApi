package com.cg.sonwane.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sonwane.ems.exceptions.UserDefinedExceptions;
import com.cg.sonwane.ems.model.Employee;
import com.cg.sonwane.ems.repository.EmployeeDao;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> employeeList = employeeDao.findAll();
		return employeeList;
	}
	
//	throws UserDefinedExceptions

	@Override
	public Employee saveEmployee(Employee employee) {
//		String empName = employee.getName();
//		if(empName.isEmpty()) {
//			throw new UserDefinedExceptions("Employee Name Cannot be null");
//		}
//		else {
			int id = sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME);
			employee.setId(id);
			employee.getAddress().setId(id);
			Employee savedEmloyee = employeeDao.save(employee);
			return savedEmloyee;
//		}
	}

	@Override
	public Employee findEmployee(Integer id) {
		Optional<Employee> employee = employeeDao.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Boolean deleteEmployeeById(Integer id) {
		Optional<Employee> employee = employeeDao.findById(id);
		if(employee.isPresent()) {
			employeeDao.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) throws UserDefinedExceptions {
		int id = employee.getId();
		if(findEmployee(id) == null) {
			throw new UserDefinedExceptions("User with "+id+" not found");
		}
		else {
			employeeDao.save(employee);
		}
		return employee;	
	}

}
