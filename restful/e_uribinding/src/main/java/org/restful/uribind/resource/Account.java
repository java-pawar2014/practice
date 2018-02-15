package org.restful.uribind.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * <p>
 * The resources describe how we can bind the parameters to the request URI for
 * which JAX-RS Runtime automatically can extract the parameters and inject into
 * respective parameter.
 * </p>
 * 
 * @author bpawar
 *
 */
@Path(value = "/account")
public class Account {

	public Account() {

	}

	/**
	 * <p>
	 * The resource has one query paramater <i>accountNo</i> (optional). If URI
	 * having multiple query params, order of the parameters can be
	 * shuffled.<br>
	 * The pretty request URI looks like:<br>
	 * <i>.../api/account/info/name?accountNo=200101524214</i>
	 * </p>
	 * 
	 * @param accountNo
	 *            a query parameter injected by JAX-RS Runtime
	 * @return account holder name, null if not found.
	 */
	@GET
	@Path(value = "/info/name")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getAccountHolderName(@QueryParam("accountNo") String accountNo) {

		return new StringBuilder().append("ACCOUNT ").append(accountNo).append(" NAME XYZ").toString();
	}

	/**
	 * <p>
	 * The resource takes one path param <i>accountNo</i> at the end of resource
	 * URI.<br>
	 * The pretty request URI for template param looks like:<br>
	 * <i>.../api/account/info/balance/200101524214</i>
	 * </p>
	 * 
	 * @param accountNo
	 * @return
	 */
	@GET
	@Path(value = "/info/balance/{accountNo}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getBalance(@PathParam("accountNo") String accountNo) {

		return new StringBuilder().append("ACCOUNT ").append(accountNo).append(" BALANCE 6658545 INR").toString();
	}

	/**
	 * <p>
	 * The resource takes one path param <i>accountNo</i> at the beginning of
	 * resource URI.<br>
	 * The pretty request URI for template param looks like:<br>
	 * <i>.../api/account/200101524214/info/balance</i>
	 * </p>
	 * 
	 * @param accountNo
	 * @return
	 */
	@GET
	@Path(value = "/{accountNo}/info/balance")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getCurrentBalance(@PathParam("accountNo") String accountNo) {

		return new StringBuilder().append("ACCOUNT ").append(accountNo).append(" BALANCE 985745 INR").toString();
	}

	/**
	 * <p>
	 * The resource takes multiple path params <i>accountNo</i> and <i>name</i>
	 * seperated by comma and forward slash.<br>
	 * The pretty request URI for template param looks like:<br>
	 * <i>.../api/account/info/balance/200101524214,pawar</i>
	 * </p>
	 * 
	 * @param accountNo
	 * @return
	 */
	@GET
	@Path(value = "/info/balance/{accountNo},{name}")
	// @Path(value = "/info/balance/{accountNo},{name}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getBalance(@PathParam("accountNo") String accountNo, @PathParam("name") String name) {

		return new StringBuilder().append("ACCOUNT ").append(accountNo).append(" NAME ").append(name)
				.append(" BALANCE 985745 INR").toString().toUpperCase();
	}
}
