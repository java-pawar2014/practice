package com.agsft.orgchart.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agsft.orgchart.enums.ECommonMessages;
import com.agsft.orgchart.enums.EDepartment;
import com.agsft.orgchart.enums.EResponseStatus;
import com.agsft.orgchart.exception.SaveException;
import com.agsft.orgchart.exception.UpdateException;
import com.agsft.orgchart.service.IDepartmentService;
import com.agsft.orgchart.util.ErrorList;
import com.agsft.orgchart.web.exception.OrgchartException;
import com.agsft.orgchart.web.model.DepartmentDTO;
import com.agsft.orgchart.web.response.WebResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;

/**
 * Core controller to handle {@link HttpServletRequest} from the client. Handles
 * the requests for different operations of Department, could be CRUD or other
 * also.
 * 
 * @author bpawar
 *
 */

@RestController
@RequestMapping(path = { "/department" })
@CrossOrigin(origins = { "*" })
@Api
@NoArgsConstructor
public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService;

	/**
	 * Request handler for always adding new department to the storage.<br>
	 * It takes and returns the department data in standard JSON format.
	 * 
	 * @param department
	 *            request body binded to {@link DepartmentDTO}
	 * @param errors
	 *            data binding errors while binding to <code>department</code>
	 * @return response on save success with status, message and body
	 * @throws OrgchartException
	 *             on save failure
	 */
	@PostMapping(path = { "/add" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Add new department")
	public ResponseEntity<WebResponse> add(@RequestBody @Validated DepartmentDTO department, Errors errors)
			throws OrgchartException {
		WebResponse response = null;
		if (errors.hasErrors()) {
			ErrorList errorList = new ErrorList();
			errorList.addAllObjectErrors(errors.getAllErrors());
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(), errorList.toString());
		}
		try {
			if (department != null)
				response = new WebResponse(HttpStatus.OK.value(), EDepartment.SAVE_SUCCESS.value(),
						departmentService.save(department));
			else
				throw new OrgchartException(EDepartment.SAVE_FAIL.value());
		} catch (Throwable cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	/**
	 * Request handler to update existing department or to add new department if
	 * not exist already in the storage.<br>
	 * The data in standard JSON format is taken to update and being returned
	 * the updated department.
	 * 
	 * @param department
	 *            request body binded to {@link DepartmentDTO}
	 * @param errors
	 *            data binding errors while binding to <code>department</code>
	 * @return response on update or new save success with status, message and
	 *         body
	 * @throws OrgchartException
	 *             on update or new save failure
	 */
	@PutMapping(path = { "/update" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Update existing department or add new if not exist")
	public ResponseEntity<WebResponse> update(@RequestBody @Validated DepartmentDTO department, Errors errors)
			throws OrgchartException {
		WebResponse response = null;
		DepartmentDTO savedDepartment = null;

		if (errors.hasErrors()) {
			ErrorList errorList = new ErrorList();
			errorList.addAllObjectErrors(errors.getAllErrors());
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(), errorList.toString());
		}
		try {
			if (department != null)
				try {
					savedDepartment = departmentService.update(department);
					response = new WebResponse(HttpStatus.OK.value(), EDepartment.UPDATE_SUCCESS.value(),
							savedDepartment);
				} catch (SaveException cause) {
					return add(department, errors);
				} catch (UpdateException cause) {
					throw new OrgchartException(cause.getMessage());
				}
			else
				throw new OrgchartException(EDepartment.UPDATE_FAIL.value());
		} catch (Throwable cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage(), savedDepartment);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/name" }, params = { "name" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search department by Name")
	public ResponseEntity<WebResponse> searchByName(@RequestParam(name = "name") String name) throws OrgchartException {
		WebResponse response = null;
		if (name == null || name.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		else
			try {
				DepartmentDTO foundDepartment = departmentService.searchByName(name);
				response = new WebResponse(HttpStatus.OK.value(), EResponseStatus.FETCHED.getMessage(),
						foundDepartment);
			} catch (Throwable cause) {
				throw new OrgchartException(HttpStatus.NO_CONTENT.value(), cause.getMessage());
			}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search department by ID")
	public ResponseEntity<WebResponse> searchById(@PathVariable String id) throws OrgchartException {
		WebResponse response = null;
		if (id == null || id.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		else
			try {
				DepartmentDTO foundDepartment = departmentService.searchById(id);
				response = new WebResponse(HttpStatus.OK.value(), EResponseStatus.FETCHED.getMessage(),
						foundDepartment);
			} catch (Throwable cause) {
				throw new OrgchartException(HttpStatus.NO_CONTENT.value(), cause.getMessage());
			}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/all" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search all departments")
	public ResponseEntity<WebResponse> searchAll() throws OrgchartException {
		WebResponse response = null;
		try {
			List<DepartmentDTO> foundDepartment = departmentService.searchAll();
			response = new WebResponse(HttpStatus.OK.value(), EResponseStatus.FETCHED.getMessage(), foundDepartment);
		} catch (Throwable cause) {
			throw new OrgchartException(HttpStatus.NO_CONTENT.value(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(path = { "/remove/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Remove department by id")
	public ResponseEntity<WebResponse> removeById(@PathVariable String id) throws OrgchartException {
		WebResponse response = null;
		if (id == null || id.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		try {
			boolean deleteFlag = departmentService.removeById(id);
			if (deleteFlag)
				response = new WebResponse(HttpStatus.OK.value(), EDepartment.REMOVE_SUCCESS.value(), null);
		} catch (Exception cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(path = { "/remove/name" }, params = { "name" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Remove department by name")
	public ResponseEntity<WebResponse> removeByName(@RequestParam(name = "name") String name) throws OrgchartException {
		WebResponse response = null;
		if (name == null || name.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		try {
			boolean deleteFlag = departmentService.removeByName(name);
			if (deleteFlag)
				response = new WebResponse(HttpStatus.OK.value(), EDepartment.REMOVE_SUCCESS.value(), null);
		} catch (Exception cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

}
