package org.kelvin.test;

import org.junit.Test;
import org.kelvin.controller.EmpController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmpController {

	/**
	 * 测试查询员工
	 */
	@Test
	public void test1() {
		String conf = "applicationContext.xml";
		ApplicationContext aContext = new ClassPathXmlApplicationContext(conf);
		EmpController empController = aContext.getBean(EmpController.class);
		empController.find();
	}
	
	/**
	 * 测试指添加员工
	 */
	@Test
	public void test2() throws ClassNotFoundException {
		String conf = "applicationContext.xml";
		ApplicationContext aContext = new ClassPathXmlApplicationContext(conf);
		EmpController ctl = aContext.getBean(EmpController.class);
		ctl.addBatch();
	}
}
