package com.agsft.orgchart.data.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agsft.orgchart.data.model.Department;
import com.agsft.orgchart.data.model.Role;
import com.agsft.orgchart.exception.DataNotFoundException;

/**
 * Interface for CRUD operations on a repository for {@link Department}.
 * 
 * @author bpawar
 *
 */
@Repository
public interface IDepartmentRepository extends MongoRepository<Department, String> {

	/**
	 * Retrieves an entity by its name.
	 * 
	 * @param name
	 *            must not be {@literal null}.
	 * @return the entity with the given name or {@literal Optional#empty()} if
	 *         none found
	 * @throws IllegalArgumentException
	 *             if {@code name} is {@literal null}.
	 */
	Optional<Department> findByName(String name);

	/**
	 * @param name
	 *            non-null and non-empty name of {@link Role}
	 * @throws DataNotFoundException
	 *             if failed to remove {@link Role}
	 */
	void deleteByName(String name) throws DataNotFoundException;

	/**
	 * Returns whether an entity with the given name exists.
	 * 
	 * @param name
	 *            must not be {@literal null}.
	 * @return {@literal true} if an entity with the given name exists,
	 *         {@literal false} otherwise.
	 * @throws IllegalArgumentException
	 *             if {@code name} is {@literal null}.
	 */
	boolean existsByName(String name);

}
