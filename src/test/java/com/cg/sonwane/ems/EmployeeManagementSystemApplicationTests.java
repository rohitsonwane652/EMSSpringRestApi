package com.cg.sonwane.ems;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sonwane.ems.repository.EmployeeDao;
import com.cg.sonwane.ems.service.EmployeeServiceImpl;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

	@Test
	void findAllEmployee_basic() {
		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		EmployeeDao mock2 = mock(EmployeeDao.class);
	}

}
