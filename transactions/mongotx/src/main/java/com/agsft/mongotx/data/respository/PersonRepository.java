package com.agsft.mongotx.data.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agsft.mongotx.data.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

	Person findByEmail(String email);

}
