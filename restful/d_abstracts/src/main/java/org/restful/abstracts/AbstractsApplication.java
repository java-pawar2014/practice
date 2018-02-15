package org.restful.abstracts;

import java.util.Set;

import javax.ws.rs.core.Application;

import org.restful.abstracts.resource.FreechargeWallet;

public class AbstractsApplication extends Application {

	private Set<Object> singletons;

	public AbstractsApplication() {
		singletons = super.getSingletons();
		singletons.add(new FreechargeWallet());
		//singletons.add(new AirtelMoneyWallet());
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
}
