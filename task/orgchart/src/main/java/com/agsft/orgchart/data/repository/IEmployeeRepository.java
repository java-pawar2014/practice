package com.agsft.orgchart.data.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agsft.orgchart.data.model.Employee;

/**
 * Interface for CRUD operations on a repository for {@link Employee}.
 * 
 * @author bpawar
 *
 */
@Repository
public interface IEmployeeRepository extends MongoRepository<Employee, String> {

	/**
	 * Retrieves an entity by its email.
	 * 
	 * @param email
	 *            must not be {@literal null}.
	 * @return the entity with the given email or {@literal Optional#empty()} if
	 *         none found
	 * @throws IllegalArgumentException
	 *             if {@code email} is {@literal null}.
	 */
	Optional<Employee> findByEmail(String email) throws IllegalArgumentException;

	/**
	 * Returns whether an entity with the given email exists.
	 * 
	 * @param email
	 *            must not be {@literal null}.
	 * @return {@literal true} if an entity with the given email exists,
	 *         {@literal false} otherwise.
	 * @throws IllegalArgumentException
	 *             if {@code id} is {@literal null}.
	 */
	boolean existsByEmail(String email) throws IllegalArgumentException;

	/**
	 * Deletes the entity with the given email.
	 * 
	 * @param email
	 *            must not be {@literal null}.
	 * @throws IllegalArgumentException
	 *             in case the given {@code email} is {@literal null}
	 */
	void deleteByEmail(String email);

}
