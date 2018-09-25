package com.agsft.droolsession;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.agsft.droolsession.model.Product;

public class DroolsTest {

	public static void main(String[] args) {
		KieServices services = KieServices.Factory.get();

		KieContainer container = services.getKieClasspathContainer();

		KieSession session = container.newKieSession("ksession-rule");

//		Product product = new Product("silver", 10);
		Product product = new Product("gold", 10);

		session.insert(product);
		session.fireAllRules();
		System.out.println("After applying rules : " + product);
		session.destroy();
	}
}
