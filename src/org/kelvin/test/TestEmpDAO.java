package org.kelvin.test;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kelvin.dao.DeptDAO;
import org.kelvin.dao.EmpDAO;
import org.kelvin.dao.VehicleDAO;
import org.kelvin.entity.Condition;
import org.kelvin.entity.Dept;
import org.kelvin.entity.Emp;
import org.kelvin.entity.Vehicle;
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
	
	/**
	 * 主键映射：新增一条员工数据
	 */
	@Test
	public void test1() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		Emp emp = new Emp();
		emp.setEname("张四");
		emp.setJob("SALESMAN");
		emp.setMgr(3);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setSal(5000.0);
		emp.setComm(650.0);
		emp.setDeptno(10);
		
		dao.save(emp);
		
		System.out.println(emp.getEmpno());
	}
	
	/**
	 * 多对一嵌套查询映射：
	 * 根据ID查询一条员工数据，并查询他所在的部门
	 */
	@Test
	public void test2() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		Emp emp = dao.findById(1);
		System.out.println(emp.getEmpno() + " " +
						   emp.getEname() + " " +
						   emp.getJob() + " " +
						   emp.getDept().getDeptno() + " " +
						   emp.getDept().getDname());
	}
	
	/**
	 * 多对一嵌套查询映射：
	 * 根据ID查询一条员工数据，并查询他所在的部门
	 */
	@Test
	public void test3() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		EmpDAO dao = ctx.getBean(EmpDAO.class);
		Emp emp = dao.findById2(1);
		System.out.println(emp.getEmpno() + " " +
						   emp.getEname() + " " +
						   emp.getJob() + " " +
						   emp.getDept().getDeptno() + " " +
						   emp.getDept().getDname());
	}
	
	/**
	 * 一对多嵌套查询映射：
	 * 查询部门及部门下所有的员工
	 */
	@Test
	public void test4() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		DeptDAO dao = ctx.getBean(DeptDAO.class);
		Dept dept = dao.findById(10);
		System.out.println(dept.getDeptno() + " " +
						   dept.getDname() + " " +
						   dept.getLoc());
		List<Emp> emps = dept.getEmps();
		for (Emp emp : emps) {
			System.out.println(emp.getEmpno() + " " +
					   emp.getEname() + " " +
					   emp.getJob());
		}
	}
	
	/**
	 * 一对多嵌套查询映射：
	 * 查询部门及部门下所有的员工
	 */
	@Test
	public void test5() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		DeptDAO dao = ctx.getBean(DeptDAO.class);
		Dept dept = dao.findById2(10);
		System.out.println(dept.getDeptno() + " " +
						   dept.getDname() + " " +
						   dept.getLoc());
		List<Emp> emps = dept.getEmps();
		for (Emp emp : emps) {
			System.out.println(emp.getEmpno() + " " +
					   emp.getEname() + " " +
					   emp.getJob());
		}
	}
	
	/**
	 * 鉴别器：
	 * 查询汽车表，根据类型封闭成不同的对象
	 */
	@Test
	public void test6() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		VehicleDAO vehicleDAO = ctx.getBean(VehicleDAO.class);
		List<Vehicle> list = vehicleDAO.findAll();
		for (Vehicle vehicle : list) {
			System.out.println(vehicle);
		}
	}
}
