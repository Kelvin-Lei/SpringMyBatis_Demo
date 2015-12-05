package org.kelvin.dao;

import java.util.List;

import org.kelvin.annotation.MyBatisRepository;
import org.kelvin.entity.Vehicle;

@MyBatisRepository
public interface VehicleDAO {

	List<Vehicle> findAll();
}
