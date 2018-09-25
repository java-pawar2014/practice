package com.agsft.orgchart.service;

import java.io.File;
import java.io.InputStream;

import com.agsft.orgchart.data.model.Department;
import com.agsft.orgchart.data.model.Employee;
import com.agsft.orgchart.data.model.Role;
import com.agsft.orgchart.enums.EColumnHeader;

/**
 * Implementations of this service must provide the bulk import operations of
 * {@link Employee}, {@link Department} and {@link Role}. Optionally
 * {@link EColumnHeader} can be used to determine the column name for reading
 * cell value.
 * 
 * @author bpawar
 *
 */
public interface IDataImportService {

	/**
	 * Super invoker for {@link #importEmployees(InputStream)},
	 * {@link #importDepartments(InputStream)} and
	 * {@link #importRoles(InputStream)}
	 * 
	 * @param file
	 *            non-null {@link File} to be imported
	 * @param entityType
	 *            type name of the entity to be imported
	 * @return true if import successful otherwise false
	 * @throws Exception
	 *             on failure of reading the file
	 */
	public boolean importRawData(InputStream file, String entityType) throws Exception;

	/**
	 * Imports the initial data of {@link Employee}s in a bulk.
	 * 
	 * @param file
	 *            non-null {@link File} to be imported
	 * @return true if import successful otherwise false
	 * @throws Exception
	 *             on failure of reading the file
	 */
	public boolean importEmployees(InputStream file) throws Exception;

	/**
	 * Imports the initial data of {@link Department}s in a bulk.
	 * 
	 * @param file
	 *            non-null {@link File} to be imported
	 * @return true if import successful otherwise false
	 * @throws Exception
	 *             on failure of reading the file
	 */
	public boolean importDepartments(InputStream file) throws Exception;

	/**
	 * Imports the initial data of {@link Role}s in a bulk.
	 * 
	 * @param file
	 *            non-null {@link File} to be imported
	 * @return true if import successful otherwise false
	 * @throws Exception
	 *             on failure of reading the file
	 */
	public boolean importRoles(InputStream file) throws Exception;

}
