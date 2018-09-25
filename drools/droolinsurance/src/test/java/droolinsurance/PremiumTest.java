package droolinsurance;

import java.util.Date;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.agsft.droolinsurance.model.Person;
import com.agsft.droolinsurance.model.Policy;
import com.agsft.droolinsurance.model.enums.PolicyType;

public class PremiumTest {

	public static void main(String[] args) {
		KieServices services = KieServices.Factory.get();
		KieContainer container = services.getKieClasspathContainer();
		KieSession session = container.newKieSession("ksession-rules");
		Policy policy = getPolicy();
		session.insert(policy);
		int count = session.fireAllRules();
		System.out.println("Rules applied : " + count);
		System.out.println(policy);
		session.destroy();
	}

	private static Policy getPolicy() {
		Policy policy = new Policy();
		Person policyHolder = new Person();
		policyHolder.setAddress("Pune");
		policyHolder.setBirthDate(new Date());
		policyHolder.setContact("9854154232");
		policyHolder.setId(200);
		policyHolder.setName("Ashok");

		policy.setExpiresOn(new Date());
		policy.setId(100);
		policy.setInsuredFrom(new Date());
		policy.setName("Life Insurance");
		policy.setPolicyHolder(policyHolder);
		policy.setPolicyType(PolicyType.INDIVIDUAL);
		policy.setPremium(2500);
		return policy;
	}
}
