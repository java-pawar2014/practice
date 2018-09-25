package com.agsft.orgchart.data.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agsft.orgchart.data.model.Role;

/**
 * Interface for CRUD operations on a repository for {@link Role}.
 * 
 * @author bpawar
 *
 */
@Repository
public interface IRoleRepository extends MongoRepository<Role, String> {

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
	Optional<Role> findByName(String name);

	/**
	 * Deletes the entity with the given name.
	 * 
	 * @param name
	 *            must not be {@literal null}.
	 * @throws IllegalArgumentException
	 *             in case the given {@code name} is {@literal null}
	 */
	void deleteByName(String name);

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
