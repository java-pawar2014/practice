package com.agsft.mongotx.service.creator;

import java.util.List;

import com.agsft.mongotx.web.exception.TransactionException;
import com.agsft.mongotx.web.model.request.PersonDTO;

/**
 * @author bpawar
 *
 */
public interface IPersonService {

	List<PersonDTO> searchAll() throws TransactionException;

	PersonDTO searchById(String id) throws TransactionException;

	PersonDTO searchByEmail(String email) throws TransactionException;

	List<PersonDTO> saveAll(List<PersonDTO> persons) throws TransactionException;

	PersonDTO save(PersonDTO person) throws TransactionException;
}
