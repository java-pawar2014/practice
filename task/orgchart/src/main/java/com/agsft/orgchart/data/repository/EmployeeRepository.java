package com.agsft.orgchart.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agsft.orgchart.data.model.Employee;

/**
 * @author bpawar
 *
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
