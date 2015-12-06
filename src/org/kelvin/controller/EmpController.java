package org.kelvin.controller;

import javax.annotation.Resource;

import org.kelvin.dao.EmpDAO;
import org.kelvin.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
@Transactional
public class EmpController {
	
	@Resource
	private EmpDAO empDAO;

	/*
	 * 查询员工
	 */
	@RequestMapping("/findEmp")
	public String find() {
		//模拟查询员工
		System.out.println("查询员工数据，发送至列表页面.");
		
		//制造一个异常
		//Integer.valueOf("abc");
		
		return "emp/emp_list.jsp";
	}
	
	/**
	 * 模拟批量添加员工
	 */
	@RequestMapping("/addEmps")
	//@Transactional(rollbackFor=ClassNotFoundException.class)
	public String addBatch() throws ClassNotFoundException {
		//插入第一个员工
		Emp e1 = new Emp();
		e1.setEname("小黄");
		e1.setJob("SALESMAN");
		e1.setSal(5000.0);
		e1.setDeptno(10);
		empDAO.save(e1);
		
		//模拟异常
		//Integer.valueOf("abc");//ClassCastException
		Class.forName("BadClass");
		
		//插入第二个员工
		Emp e2 = new Emp();
		e2.setEname("小虎");
		e2.setJob("SALESMAN");
		e2.setSal(5000.0);
		e2.setDeptno(10);
		empDAO.save(e2);
		
		return "redirect:findEmp";
	}
}
