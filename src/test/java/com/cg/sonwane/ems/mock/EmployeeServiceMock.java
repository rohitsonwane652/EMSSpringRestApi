package com.cg.sonwane.ems.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.sonwane.ems.exceptions.UserDefinedExceptions;
import com.cg.sonwane.ems.model.Address;
import com.cg.sonwane.ems.model.DatabaseSequence;
import com.cg.sonwane.ems.model.Employee;
import com.cg.sonwane.ems.repository.EmployeeDao;
import com.cg.sonwane.ems.service.EmployeeService;
import com.cg.sonwane.ems.service.EmployeeServiceImpl;
import com.cg.sonwane.ems.service.SequenceGeneratorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceMock {
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@MockBean
	private EmployeeDao employeeDao;
	
	private Employee employee;
	
	@BeforeEach
	public void setup() {
		employee = new Employee(1,"Rohit","C&CA","Analyst",new Address(1,"Raghunath","4","5th","NaviMumbai",43123));
	}
	
	@Test
	public void FindAll_test() {
		when(employeeDao.findAll()).thenReturn(List.of(employee));
		List<Employee> empList = employeeService.findAllEmployee();
		assertThat(empList).isNotNull();
		assertThat(empList.size()).isEqualTo(1);
	}
	
	
	
	@Test
	public void addEmployee_test() throws UserDefinedExceptions {
//		Employee emp = new Employee(1,"Rohit","C&CA","Analyst",new Address(1,"Raghunath","4","5th","NaviMumbai",43123));
		Mockito.when(employeeDao.save(employee)).thenReturn(employee);
		Employee actualResult = employeeService.saveEmployee(employee);
		assertEquals(employee, actualResult);
		
	}
	
	@Test
	public void findEmployee_test() {
		when(employeeDao.findById(1)).thenReturn(Optional.of(employee));
		Employee actualResult = employeeService.findEmployee(1);
		assertEquals(employee,actualResult);
	}
	
	@Test
	public void updateEmployee_test() throws UserDefinedExceptions {
		Employee emp = new Employee(1,"Aman","C&CA","Analyst",new Address(1,"Raghunath","4","5th","NaviMumbai",43123));
		Mockito.when(employeeDao.save(emp)).thenReturn(emp);
		Employee actualResult = employeeService.updateEmployee(employee);
		assertEquals(employee, actualResult);
	}
	

}
