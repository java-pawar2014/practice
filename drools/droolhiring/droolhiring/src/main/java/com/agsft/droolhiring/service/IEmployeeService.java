/**
 * 
 */
package com.agsft.droolhiring.service;

import com.agsft.droolhiring.dto.CandidateDTO;
import com.agsft.droolhiring.model.Employee;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public interface IEmployeeService {

	Employee save(Employee employee);

	CandidateDTO filter(CandidateDTO candidate);

}
