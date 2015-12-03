package org.kelvin.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.kelvin.dao.EmpDAO;
import org.kelvin.entity.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmpDAO {

	@Test
	public void testFindAll() throws IOException {
		String conf = "applicationContext.xml";
		ApplicationContext aContext = new ClassPathXmlApplicationContext(conf);
		EmpDAO empDAO = aContext.getBean("empDAO", EmpDAO.class);
		List<Emp> list = empDAO.findAll();
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " + emp.getEname());
		}
	}
}
