package org.restful.injection.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The resources talks about path params. The path params are always mandatory.
 * 
 * @author bpawar
 *
 */
@Path(value = "/account")
public class Account {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/details/{accountNo}-{city}")
	public String getAccountDetails(@PathParam("accountNo") String accountNo, @PathParam("city") String city) {
		return "Account No.: " + accountNo + " Holder Name: Ram" + " City: " + city;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/branch/{accountNo}")
	public String getBranchDetails(@PathParam("accountNo") String accountNo) {
		return "Account No.: " + accountNo + " Branch: Pune";
	}

}
