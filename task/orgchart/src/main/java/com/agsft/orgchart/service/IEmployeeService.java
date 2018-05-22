package com.agsft.orgchart.service;

import java.io.File;
import java.util.List;

import com.agsft.orgchart.data.model.Employee;
import com.agsft.orgchart.web.model.EmployeeDTO;

/**
 * The implementation must be implemented for search, new save, delete and
 * existing update for the model {@link Employee}.
 * 
 * @author bpawar
 *
 */
public interface IEmployeeService {

	/**
	 * Returns {@link Employee} for the provided id. The id must not be null.
	 * Throw {@link IllegalArgumentException} if id is null or empty
	 * 
	 * @param id
	 *            non-null and non-empty id of employee
	 * @return object of {@link Employee} for id if found else null
	 * @throws IllegalArgumentException
	 *             if id is null or empty
	 */
	EmployeeDTO findById(String id) throws IllegalArgumentException;

	/**
	 * Returns all {@link Employee} as {@link List} if found else return empty
	 * list.
	 * 
	 * @return list of {@link Employee} if found else empty
	 */
	List<EmployeeDTO> findAll();

	/**
	 * Creates new {@link Employee} in storage and returns newly created.
	 * 
	 * @param employee
	 *            non-null instance of {@link Employee}
	 * @return newly created {@link Employee} instance
	 * @throws IllegalArgumentException
	 *             if argument employee is null
	 */
	EmployeeDTO save(EmployeeDTO employee) throws IllegalArgumentException;

	/**
	 * Updates existing {@link Employee} in storage and returns updated. First
	 * look for the provided id, if found then update existing and if not found
	 * create new. It returns newly created of updated.
	 * 
	 * @param employee
	 *            non-null instance of {@link Employee}
	 * @return updated or newly created {@link Employee} instance
	 * @throws IllegalArgumentException
	 *             if argument employee is null
	 */
	EmployeeDTO update(EmployeeDTO employee) throws IllegalArgumentException;

	/**
	 * Removes existing {@link Employee} from storage and returns boolean true
	 * if success else false.
	 * 
	 * @param employee
	 *            non-null instance of {@link Employee}
	 * @return true if removed else false
	 * @throws IllegalArgumentException
	 *             if argument employee is null
	 */
	Boolean remove(EmployeeDTO employee) throws IllegalArgumentException;

	/**
	 * Removes existing {@link Employee} for provided id from storage and
	 * returns boolean true if success else false. If {@link Employee} for given
	 * id is not present, always return false
	 * 
	 * @param id
	 *            non-null and non-empty id of employee
	 * @return true if removed else false
	 * @throws IllegalArgumentException
	 *             if argument employee is null
	 */
	Boolean remove(String id) throws IllegalArgumentException;

	/**
	 * Imports the initial data in a bulk.
	 * 
	 * @param file
	 *            non-null {@link File} to be imported
	 * @return true if import successful otherwise false
	 */
	public boolean importData(File file) throws Throwable;

}
