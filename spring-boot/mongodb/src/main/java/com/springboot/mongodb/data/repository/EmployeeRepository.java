package com.springboot.mongodb.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongodb.bean.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
