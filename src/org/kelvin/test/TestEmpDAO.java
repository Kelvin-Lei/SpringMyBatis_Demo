package org.kelvin.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kelvin.dao.EmpDAO;
import org.kelvin.entity.Condition;
import org.kelvin.entity.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmpDAO {

	@Test
	public void testFindAll() throws IOException {
		String conf = "applicationContext.xml";
		ApplicationContext aContext = new ClassPathXmlApplicationContext(conf);
		EmpDAO empDAO = aContext.getBean(EmpDAO.class);
		List<Emp> list = empDAO.findAll();
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " + emp.getEname() + " " + emp.getJob());
		}
	}
	
	@Test
	public void testFindByDept() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		Condition condition = new Condition();
		condition.setDeptno(30);
		List<Emp> list = dao.findByDept(condition);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " +
							   emp.getEname() + " " +
							   emp.getJob());
		}
	}
	
	@Test
	public void testFindBySalary() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		Condition condition = new Condition();
		condition.setSalary(4000.0);
		List<Emp> list = dao.findBySalary(condition);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " +
					   emp.getEname() + " " +
					   emp.getJob());
		}
	}
	
	@Test
	public void testFindByDeptAndSalary() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		Condition condition = new Condition();
		condition.setDeptno(20);
		condition.setSalary(2000.0);
		List<Emp> list = dao.findByDeptAndSalary(condition);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " +
					   emp.getEname() + " " +
					   emp.getJob());
		}
	}
	
	@Test
	public void testUpdate() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		Emp emp = new Emp();
		emp.setEmpno(1);
		emp.setEname("Leo");
		dao.update(emp);
	}
	
	@Test
	public void testFindByDeptAndSalary2() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		Condition condition = new Condition();
		condition.setDeptno(20);
		condition.setSalary(2000.0);
		List<Emp> list = dao.findByDeptAndSalary2(condition);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " +
					   emp.getEname() + " " +
					   emp.getJob());
		}
	}
	
	@Test
	public void testUpdate2() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		Emp emp = new Emp();
		emp.setEmpno(1);
		emp.setEname("Lee");
		dao.update2(emp);
	}
	
	@Test
	public void testFindByIds() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		Condition condition = new Condition();
		condition.setEmpnos(ids);
		List<Emp> list = dao.findByIds(condition);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " +
					   emp.getEname() + " " +
					   emp.getJob());
		}
	}
}
