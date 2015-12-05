package org.kelvin.dao;

import java.util.List;

import org.kelvin.annotation.MyBatisRepository;
import org.kelvin.entity.Condition;
import org.kelvin.entity.Emp;

/**
 * 
 * 员工表的DAO组件
 *
 */
@MyBatisRepository
public interface EmpDAO {

	public List<Emp> findAll();
	
	public List<Emp> findByDept(Condition cond);
	
	public List<Emp> findBySalary(Condition cond);
	
	public List<Emp> findByDeptAndSalary(Condition cond);
	
	public void update(Emp emp);
	
	public List<Emp> findByDeptAndSalary2(Condition cond);
	
	public void update2(Emp emp);
	
	public List<Emp> findByIds(Condition cond);
	
	public void save(Emp emp);
	
	public Emp findById(int id);
	
	public Emp findById2(int id);
}
