package org.kelvin.dao;

import org.kelvin.annotation.MyBatisRepository;
import org.kelvin.entity.Dept;

@MyBatisRepository
public interface DeptDAO {

	public Dept findById(int id);
	
	public Dept findById2(int id);
}
