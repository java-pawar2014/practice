package com.agsft.orgchart.service;

import com.agsft.orgchart.data.model.Department;

/**
 * @author bpawar
 *
 */
public interface IDepartmentService {

	Department findById(String id);
	
	Department findByName(String name);
	
	Department save(Department department);

	Department update(Department department);

	Boolean remove(Department department);

	Boolean remove(String id);

}
