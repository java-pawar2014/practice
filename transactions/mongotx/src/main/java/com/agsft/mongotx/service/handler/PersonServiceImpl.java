package com.agsft.mongotx.service.handler;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.agsft.mongotx.data.model.Person;
import com.agsft.mongotx.data.respository.PersonRepository;
import com.agsft.mongotx.service.creator.IPersonService;
import com.agsft.mongotx.util.TransactionUtility;
import com.agsft.mongotx.web.exception.TransactionException;
import com.agsft.mongotx.web.model.request.PersonDTO;

/**
 * @author bpawar
 *
 */
@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private TransactionUtility utility;

	@Override
	public List<PersonDTO> searchAll() throws TransactionException {
		List<Person> persons = (List<Person>) repository.findAll();
		if (persons.isEmpty())
			throw new TransactionException(HttpStatus.OK.value(), "Persons not found");
		return utility.convertValues(persons, PersonDTO.class);
	}

	@Override
	public PersonDTO searchById(String id) throws TransactionException {
		return utility.convertValue(repository.findById(id), PersonDTO.class);
	}

	@Override
	public PersonDTO searchByEmail(String email) throws TransactionException {
		return utility.convertValue(repository.findByEmail(email), PersonDTO.class);
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {
			SQLException.class })
	@Override
	public List<PersonDTO> saveAll(List<PersonDTO> persons) throws TransactionException {
		try {
			return utility.convertValues(repository.saveAll(utility.convertValues(persons, Person.class)),
					PersonDTO.class);
		} catch (TransactionException cause) {
			throw new TransactionException(cause.getStatusCode(), cause.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new TransactionException(HttpStatus.OK.value(), "Failed to save Person(s)", persons);
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public PersonDTO save(PersonDTO person) throws TransactionException {
		try {
			return utility.convertValue(repository.save(utility.convertValue(person, Person.class)), PersonDTO.class);
		} catch (TransactionException cause) {
			throw new TransactionException(cause.getStatusCode(), cause.getMessage());
		} catch (Exception e) {
			throw new TransactionException(HttpStatus.OK.value(), "Failed to save Person", person);
		}
	}
}
