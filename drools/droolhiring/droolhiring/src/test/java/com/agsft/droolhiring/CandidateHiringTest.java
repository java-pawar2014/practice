package com.agsft.droolhiring;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

import com.agsft.droolhiring.dto.CandidateDTO;
import com.agsft.droolhiring.service.IEmployeeService;
import com.agsft.droolhiring.service.impl.EmployeeServiceImpl;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public class CandidateHiringTest {

	public static void main(String[] args) {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

		IEmployeeService employeeService = new EmployeeServiceImpl(kieContainer);
		CandidateDTO candidate = candidate();
		for (String skill : candidate.getSkills()) {
			if (skill.contains("java")) {
				candidate.setJavaSkill(true);
				break;
			}
		}
		employeeService.filter(candidate);
		System.out.println(candidate);
	}

	private static CandidateDTO candidate() {
		return new CandidateDTO("john", "9523661245", new String[] { "java, spring" });
	}
}
