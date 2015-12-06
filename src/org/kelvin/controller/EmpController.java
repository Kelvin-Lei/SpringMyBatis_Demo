package org.kelvin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kelvin.dao.EmpDAO;
import org.kelvin.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Resource
	private EmpDAO empDAO;
	
	//@RequestMapping("/findEmp")
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public String find(Model model) {
		List<Emp> list = empDAO.findAll();
		model.addAttribute("emps", list);
		return "emp/emp_list";
	}
	
	/**
	 * 打开新增页面
	 */
	//@RequestMapping("/toAddEmp")
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd() {
		return "emp/add_emp";
	}
	
	/**
	 * 新增保存
	 */
	//@RequestMapping("/addEmp")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Emp emp) {
		empDAO.save(emp);
		//return "redirect:findEmp";
		return "redirect:find";
	}
	
	/**
	 * 打开修改页面
	 */
	//@RequestMapping("/toUpdateEmp")
	@RequestMapping(value="/toUpdate/{id}",method=RequestMethod.GET)
	public String toUpdate(/*@RequestParam("id")*/@PathVariable("id") int id, Model model) {
		Emp e = empDAO.findById(id);
		model.addAttribute("emp", e);
		return "emp/update_emp";
	}
	
	/**
	 * 修改保存
	 */
//	@RequestMapping("/updateEmp")
//	public String update(Emp emp) {
//		empDAO.update(emp);
//		return "redirect:findEmp";
//	}
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public boolean update(@RequestBody Emp emp) {
		empDAO.update(emp);
		return true;
	}
	
	/**
	 * 删除
	 */
//	@RequestMapping("/deleteEmp")
//	public String delete(@RequestParam("id") int id) {
//		empDAO.delete(id);
//		return "redirect:findEmp";
//	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public boolean delete(@PathVariable("id") int id) {
		empDAO.delete(id);
		return true;
	}
}
