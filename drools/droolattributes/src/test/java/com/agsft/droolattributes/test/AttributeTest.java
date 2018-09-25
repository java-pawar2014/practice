package com.agsft.droolattributes.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.agsft.droolattributes.fact.Fare;
import com.agsft.droolattributes.fact.TaxiRide;

public class AttributeTest {

	public static void main(String[] args) {
		KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
		KieSession session = container.newKieSession("attribute-rules");

		Fare fare = new Fare(0, 40);
		TaxiRide taxiRide = new TaxiRide(true, 30);

		session.insert(fare);
		session.insert(taxiRide);

		session.fireAllRules();

		System.out.println(fare);
	}
}
