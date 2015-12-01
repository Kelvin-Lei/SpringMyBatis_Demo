package org.kelvin.dao;

import java.util.List;

import org.kelvin.entity.Dept;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisDeptDAO implements DeptDAO{

	@Autowired
	private SqlSessionTemplate template;
	
	public List<Dept> findAll() {
		List<Dept> list = template.selectList("findAll");
		return list;
	}

}
