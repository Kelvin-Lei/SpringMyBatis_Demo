package org.kelvin.web;

import java.util.List;

import javax.annotation.Resource;

import org.kelvin.dao.EmpDAO;
import org.kelvin.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpListController {

	@Resource
	private EmpDAO dao;
	
	@RequestMapping("/list")
	public String execute(Model model) {
		List<Emp> list = dao.findAll();
		model.addAttribute("emps", list);
		return "emp/emp_list";
	}
}
