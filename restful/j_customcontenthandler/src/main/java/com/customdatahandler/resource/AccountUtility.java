package com.customdatahandler.resource;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.customdatahandler.dto.Account;
import com.customdatahandler.dto.CreateAccountForm;

@Path("/utility/account")
public class AccountUtility {

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/create")
	public Account createAccount(CreateAccountForm accountForm) {
		Account account = null;

		account = new Account();
		account.setName(accountForm.getFirstName() + " " + accountForm.getLastName());
		account.setEmail(accountForm.getEmail());
		account.setAccountId(accountForm.getEmail().split("@")[0]);
		return account;
	}

	@GET
	@Path("/info/{accountNo}")
	@Produces(value = { MediaType.TEXT_PLAIN, MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_JSON })
	public CreateAccountForm getAccount(@PathParam("accountNo") String accountNo) {

		CreateAccountForm accountForm = null;

		System.out.println("AccountUtility.getAccount");
		accountForm = new CreateAccountForm();
		accountForm.setFirstName("Root");
		accountForm.setLastName("User");
		accountForm.setGender("MALE");
		accountForm.setEmail("rootuser@gmail.com");
		accountForm.setBirthDate(new Date());
		accountForm.setPassword("root");
		return accountForm;
	}
}
