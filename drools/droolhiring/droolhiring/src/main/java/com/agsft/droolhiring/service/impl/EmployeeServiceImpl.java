package com.agsft.droolhiring.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.agsft.droolhiring.dto.CandidateDTO;
import com.agsft.droolhiring.enums.Constant;
import com.agsft.droolhiring.model.Employee;
import com.agsft.droolhiring.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private KieContainer kieContainer;

	public EmployeeServiceImpl(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	@Override
	public Employee save(Employee employee) {
		return null;
	}

	@Override
	public CandidateDTO filter(CandidateDTO candidate) {
		KieSession session = kieContainer.newKieSession(Constant.KIE_RULES.value());
		session.insert(candidate);
		session.fireAllRules();
		session.destroy();
		return candidate;
	}

}
