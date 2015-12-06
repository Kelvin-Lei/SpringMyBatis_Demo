package org.kelvin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpController {

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
}
