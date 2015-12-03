package org.kelvin.dao;

import java.util.List;

import org.kelvin.annotation.MyBatisRepository;
import org.kelvin.entity.Emp;

@MyBatisRepository
public interface EmpDAO {

	public List<Emp> findAll();
}
