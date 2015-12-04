package org.kelvin.dao;

import java.util.List;

import org.kelvin.annotation.MyBatisRepository;
import org.kelvin.entity.Emp;

/**
 * 
 * 员工表的DAO组件
 *
 */
@MyBatisRepository
public interface EmpDAO {

	public List<Emp> findAll();
}
