package com.agsft.orgchart.service;

import java.util.List;

import com.agsft.orgchart.data.model.Employee;
import com.agsft.orgchart.data.repository.IEmployeeRepository;
import com.agsft.orgchart.exception.DataNotFoundException;
import com.agsft.orgchart.exception.DeleteException;
import com.agsft.orgchart.exception.SaveException;
import com.agsft.orgchart.exception.UpdateException;
import com.agsft.orgchart.web.model.EmployeeDTO;

/**
 * The implementation must be implemented for search, new save, delete and
 * existing update for the {@link Employee}.<br>
 * 
 * @see IEmployeeRepository
 * @author bpawar
 *
 */
public interface IEmployeeService {

	/**
	 * Implementation must return an {@link EmployeeDTO} looking in to storage
	 * by its id.
	 * 
	 * @param id
	 *            must not be {@literal null}.
	 * @return the {@link EmployeeDTO} with the given id
	 * @throws DataNotFoundException
	 *             if {@code id} is {@literal null} or entity not found.
	 */
	EmployeeDTO searchById(String id) throws DataNotFoundException;

	/**
	 * Implementation must return an {@link EmployeeDTO} looking in to storage
	 * by its email.
	 * 
	 * @param email
	 *            must not be {@literal null}.
	 * @return the {@link EmployeeDTO} with the given email
	 * @throws DataNotFoundException
	 *             if {@code email} is {@literal null} or entity not found.
	 */
	EmployeeDTO searchByEmail(String email) throws DataNotFoundException;

	/**
	 * Returns all {@link EmployeeDTO} as list if found
	 * 
	 * @return not empty list of {@link EmployeeDTO}s
	 * @throws DataNotFoundException
	 *             if no {@link EmployeeDTO}s found
	 */
	List<EmployeeDTO> searchAll() throws DataNotFoundException;

	/**
	 * Saves a given entity. Use the returned instance for further operations as
	 * the save operation might have changed the entity instance completely.
	 * 
	 * @param employee
	 *            must not be {@literal null}.
	 * @return the saved entity will never be {@literal null}.
	 * @throws SaveException
	 *             if fails to save
	 */
	EmployeeDTO save(EmployeeDTO employee) throws SaveException;

	/**
	 * Iterates over the list and creates new {@link EmployeeDTO} in storage for
	 * each iteration and returns list of newly persisted entities.
	 * 
	 * @see #save(EmployeeDTO)
	 * @param employees
	 *            non-null and non-empty instance of list of {@link EmployeeDTO}
	 * @return list of newly created {@link EmployeeDTO} instances
	 * @throws SaveException
	 *             on failure to persist new {@link EmployeeDTO}
	 */
	List<EmployeeDTO> saveAll(List<EmployeeDTO> employees) throws SaveException;

	/**
	 * Updates existing {@link EmployeeDTO} in storage and returns updated.
	 * First look for the provided id, if found then update existing and if not
	 * found create new. It returns newly created of updated.
	 * 
	 * @see #save(EmployeeDTO)
	 * @param employee
	 *            non-null instance of {@link EmployeeDTO}
	 * @return updated or newly created {@link EmployeeDTO} instance
	 * @throws UpdateException
	 *             on failure to update and persist existing
	 * @throws SaveException
	 *             on failure of save when new creation
	 */
	EmployeeDTO update(EmployeeDTO employee) throws SaveException, UpdateException;

	/**
	 * Removes {@link EmployeeDTO} for email
	 * 
	 * @param email
	 *            non-null and non-empty email of {@link EmployeeDTO}
	 * @return true on removal otherwise false
	 * @throws DeleteException
	 *             if {@link EmployeeDTO} not found for given email
	 * @see #searchByEmail(String)
	 */
	boolean removeByEmail(String email) throws DeleteException;

	/**
	 * Removes {@link EmployeeDTO} for id
	 * 
	 * @param id
	 *            non-null and non-empty id of {@link EmployeeDTO}
	 * @return true on removal otherwise false
	 * @throws DeleteException
	 *             if {@link EmployeeDTO} not found for given id
	 * @see #searchById(String)
	 */
	boolean removeById(String id) throws DeleteException;

}
