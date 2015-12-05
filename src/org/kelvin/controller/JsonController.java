package org.kelvin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kelvin.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class JsonController {

	@RequestMapping("/test1")
	@ResponseBody
	public boolean test1() {
		return true;
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public Map<String, Object> test2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 16);
		map.put("name", "刘备");
		return map;
	}
	
	@RequestMapping("/test3")
	@ResponseBody
	public List<String> test3() {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		return list;
	}
	
	@RequestMapping("/test4")
	@ResponseBody
	public Emp test4() {
		Emp emp = new Emp();
		emp.setEmpno(1);
		emp.setEname("小明");
		emp.setJob("打怪");
		emp.setMgr(1);
		emp.setSal(10000.0);
		emp.setDeptno(10);
		return emp;
	}
	
	@RequestMapping("/test5")
	@ResponseBody
	public List<Emp> test5() {
		List<Emp> list = new ArrayList<Emp>();
		
		Emp e1 = new Emp();
		e1.setEmpno(1);
		e1.setEname("小明");
		e1.setJob("打怪");
		e1.setMgr(1);
		e1.setSal(10000.0);
		e1.setDeptno(10);
		list.add(e1);
		
		Emp e2 = new Emp();
		e2.setEmpno(2);
		e2.setEname("小花");
		e2.setJob("打怪2");
		e2.setMgr(2);
		e2.setSal(11000.0);
		e2.setDeptno(10);
		list.add(e2);
		
		return list;
	}
}
