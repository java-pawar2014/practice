package com.agsft.orgchart.service;

import java.util.List;

import com.agsft.orgchart.data.model.Department;
import com.agsft.orgchart.data.repository.IDepartmentRepository;
import com.agsft.orgchart.exception.DataNotFoundException;
import com.agsft.orgchart.exception.DeleteException;
import com.agsft.orgchart.exception.SaveException;
import com.agsft.orgchart.exception.UpdateException;
import com.agsft.orgchart.web.model.DepartmentDTO;

/**
 * The implementation must be implemented for search, new save, delete and
 * existing update for the {@link Department}. <br>
 * 
 * @see IDepartmentRepository
 * @author bpawar
 *
 */
public interface IDepartmentService {

	/**
	 * Returns all {@link DepartmentDTO} as list if found
	 * 
	 * @return not empty list of {@link DepartmentDTO}s
	 * @throws DataNotFoundException
	 *             if no {@link DepartmentDTO}s found
	 */
	List<DepartmentDTO> searchAll() throws DataNotFoundException;

	/**
	 * Implementation must return an {@link DepartmentDTO} looking in to storage
	 * by its id.
	 * 
	 * @param id
	 *            must not be {@literal null}.
	 * @return the {@link DepartmentDTO} with the given id
	 * @throws DataNotFoundException
	 *             if {@code id} is {@literal null} or entity not found.
	 */
	DepartmentDTO searchById(String id) throws DataNotFoundException;

	/**
	 * Implementation must return an {@link DepartmentDTO} looking in to storage
	 * by its name.
	 * 
	 * @param name
	 *            must not be {@literal null}.
	 * @return the {@link DepartmentDTO} with the given name
	 * @throws DataNotFoundException
	 *             if {@code name} is {@literal null} or entity not found.
	 */
	DepartmentDTO searchByName(String name) throws DataNotFoundException;

	/**
	 * Saves a given entity. Use the returned instance for further operations as
	 * the save operation might have changed the entity instance completely.
	 * 
	 * @param department
	 *            must not be {@literal null}.
	 * @return the saved entity will never be {@literal null}.
	 * @throws SaveException
	 *             if fails to save
	 */
	DepartmentDTO save(DepartmentDTO department) throws SaveException;

	/**
	 * Iterates over the list and creates new {@link DepartmentDTO} in storage
	 * for each iteration and returns list of newly persisted entities.
	 * 
	 * @see #save(DepartmentDTO)
	 * @param departments
	 *            non-null and non-empty instance of list of
	 *            {@link DepartmentDTO}
	 * @return list of newly created {@link DepartmentDTO} instances
	 * @throws SaveException
	 *             on failure to persist new {@link DepartmentDTO}
	 */
	List<DepartmentDTO> saveAll(List<DepartmentDTO> departments) throws SaveException;

	/**
	 * Updates existing {@link DepartmentDTO} in storage and returns updated.
	 * First look for the provided id, if found then update existing and if not
	 * found create new. It returns newly created of updated.
	 * 
	 * @see #save(DepartmentDTO)
	 * @param department
	 *            non-null instance of {@link DepartmentDTO}
	 * @return updated or newly created {@link DepartmentDTO} instance
	 * @throws UpdateException
	 *             on failure to update and persist existing
	 * @throws SaveException
	 *             on failure of save when new creation
	 */
	DepartmentDTO update(DepartmentDTO department) throws UpdateException, SaveException;

	/**
	 * Removes {@link DepartmentDTO} for name
	 * 
	 * @see #searchByName(String)
	 * @param name
	 *            non-null and non-empty name of {@link DepartmentDTO}
	 * @return true on removal otherwise false
	 * @throws DeleteException
	 *             if {@link DepartmentDTO} not found for given name
	 */
	boolean removeByName(String name) throws DeleteException;

	/**
	 * Removes {@link DepartmentDTO} for id
	 * 
	 * @param id
	 *            non-null and non-empty id of {@link DepartmentDTO}
	 * @return true on removal otherwise false
	 * @throws DeleteException
	 *             if {@link DepartmentDTO} not found for given id
	 * @see #searchById(String)
	 */
	boolean removeById(String id) throws DeleteException;

}
