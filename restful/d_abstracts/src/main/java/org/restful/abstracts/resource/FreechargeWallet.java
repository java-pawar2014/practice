package org.restful.abstracts.resource;

import javax.ws.rs.Path;

//@Path("/freecWallet")
public class FreechargeWallet implements MoneyEWallet {

	@Override
	public String getBalance(String accountId) {
		System.out.println("Invoked FreechargeWallet.getBalance(String)");
		return "Available Balance for a/c " + accountId + " is " + 552414 + " INR.";
	}
}
