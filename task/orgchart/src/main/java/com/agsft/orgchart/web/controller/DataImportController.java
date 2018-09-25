package com.agsft.orgchart.web.controller;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agsft.orgchart.service.IDataImportService;
import com.agsft.orgchart.web.exception.OrgchartException;
import com.agsft.orgchart.web.response.WebResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;

/**
 * Core controller to handle {@link HttpServletRequest} from the client.
 * Specialized for importing the different type of data.
 * 
 * @author bpawar
 *
 */
@RestController
@RequestMapping(path = { "/import" })
@CrossOrigin(origins = { "*" })
@Api
@NoArgsConstructor
public class DataImportController {

	@Autowired
	private IDataImportService dataImportService;

	/**
	 * Request handler for importing the data of employees, always responds for
	 * POST request of HTTP Request.
	 * 
	 * @see #importData(MultipartFile, String)
	 * @param file
	 *            raw file from request body
	 * @return import status with message
	 * @throws OrgchartException
	 *             if file is empty or fails to import
	 */
	@PostMapping(path = "/employees", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Import employees")
	public ResponseEntity<WebResponse> importEmployees(@RequestBody MultipartFile file) throws OrgchartException {
		return importData(file, "employees");
	}

	/**
	 * Request handler for importing the data of roles, always responds for POST
	 * request of HTTP Request.
	 * 
	 * @see #importData(MultipartFile, String)
	 * @param file
	 *            raw file from request body
	 * @return import status with message
	 * @throws OrgchartException
	 *             if file is empty or fails to import
	 */
	@PostMapping(path = "/roles", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Import roles")
	public ResponseEntity<WebResponse> importRoles(@RequestBody MultipartFile file) throws OrgchartException {
		return importData(file, "roles");
	}

	/**
	 * Request handler for importing the data of departments, always responds
	 * for POST request of HTTP Request.
	 * 
	 * @see #importData(MultipartFile, String)
	 * @param file
	 *            raw file from request body
	 * @return import status with message
	 * @throws OrgchartException
	 *             if file is empty or fails to import
	 */
	@PostMapping(path = "/departments", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Import departments")
	public ResponseEntity<WebResponse> importDepartments(@RequestBody MultipartFile file) throws OrgchartException {
		return importData(file, "departments");
	}

	/**
	 * Common importer for all type of data
	 * 
	 * @see #importDepartments(MultipartFile)
	 * @see #importEmployees(MultipartFile)
	 * @see #importRoles(MultipartFile)
	 * @param file
	 *            raw file retrieved from request body
	 * @param entityType
	 *            tells the specific entity on to which data to be binded
	 * @return import status with message
	 * @throws OrgchartException
	 *             if file is empty or fails to import
	 */
	public ResponseEntity<WebResponse> importData(MultipartFile file, String entityType) throws OrgchartException {
		WebResponse response = null;
		boolean importFlag = false;

		if (file.isEmpty()) {
			response = new WebResponse(HttpStatus.NO_CONTENT.value(), "No file selected or file is empty.");
		} else {
			try {
				InputStream fileStream = file.getInputStream();
				importFlag = dataImportService.importRawData(fileStream, entityType);
				if (importFlag)
					response = new WebResponse(HttpStatus.OK.value(),
							"Data for " + entityType + " is imported successfully");
				else
					throw new OrgchartException(HttpStatus.BAD_REQUEST.value(),
							"Failed to import the data for " + entityType);

			} catch (Exception cause) {
				throw new OrgchartException(HttpStatus.BAD_REQUEST.value(), cause.getMessage());
			}
		}
		return ResponseEntity.ok(response);
	}
}
