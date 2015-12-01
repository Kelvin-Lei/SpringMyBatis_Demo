package org.kelvin.mapper;

import java.util.List;

import org.kelvin.annotation.MyBatisRepository;
import org.kelvin.entity.Dept;

@MyBatisRepository
public interface DeptMapper {
	
	public List<Dept> findAll();

}
