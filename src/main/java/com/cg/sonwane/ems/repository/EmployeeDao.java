package com.cg.sonwane.ems.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.sonwane.ems.model.Employee;

public interface EmployeeDao extends MongoRepository<Employee, Integer>{
	public List<Employee> findAll();
	public Optional<Employee> findById(Integer id);
	public Employee save(Employee employee);
	public void deleteById(Integer id);
}
