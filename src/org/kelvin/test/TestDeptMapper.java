package org.kelvin.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.kelvin.entity.Dept;
import org.kelvin.mapper.DeptMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDeptMapper {
	
	@Test
	public void testFindAll() throws IOException {
		String conf = "applicationContext.xml";
		ApplicationContext aContext = new ClassPathXmlApplicationContext(conf);
		DeptMapper mapper = aContext.getBean("deptMapper", DeptMapper.class);
		List<Dept> list = mapper.findAll();
		for (Dept dept : list) {
			System.out.println(dept.getDeptno() + " " + dept.getDname());
		}
	}
	
	@Test
	public void testScanFindAll() throws IOException {
		String conf = "applicationContext-scan.xml";
		ApplicationContext aContext = new ClassPathXmlApplicationContext(conf);
		DeptMapper mapper = aContext.getBean("deptMapper", DeptMapper.class);
		List<Dept> list = mapper.findAll();
		for (Dept dept : list) {
			System.out.println(dept.getDeptno() + " " + dept.getDname());
		}
	}
	
	@Test
	public void testScanAnnotationFindAll() throws IOException {
		String conf = "applicationContext-scan-annotation.xml";
		ApplicationContext aContext = new ClassPathXmlApplicationContext(conf);
		DeptMapper mapper = aContext.getBean("deptMapper", DeptMapper.class);
		List<Dept> list = mapper.findAll();
		for (Dept dept : list) {
			System.out.println(dept.getDeptno() + " " + dept.getDname());
		}
	}
}
