package org.restful.abstracts.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 
 * <b>Resteasy Implementation</b>
 * <ol>
 * <li>If we wrote @Path only at interface level and provide multiple
 * implementations, the 'resteasy' implementation picks the implemented resource
 * randomly. For every request we will get alternative outputs.</li>
 * <li>If we wrote @Path at implemented class, the resteasy will overrides the
 * annotation written at interface level and annotation written at class level
 * will be considered. (To test this, write different url-pattern in @Path).
 * </li>
 * </ol>
 * <b>Jersey Implementation</b>
 * <ol>
 * <li>If we wrote @Path at interface level and send request we will get
 * java.lang.NoSuchMethodException: Could not find a suitable constructor in
 * org.restful.abstracts.resource.MoneyEWallet class.</li>
 * <li>If we wrote @Path at one implemented class, the jersey will consider
 * annotation written at implemented class level. If we write @Path with same
 * url-pattern at multiple implemented classes, our application will not gets
 * deployed. <i>(A resource model has ambiguous (sub-)resource method for HTTP
 * method GET and input mime-types as defined by"@Consumes" and "@Produces"
 * annotations at Java methods public java.lang.String
 * org.restful.abstracts.resource.FreechargeWallet.getBalance(java.lang.String)
 * and public java.lang.String
 * org.restful.abstracts.resource.AirtelMoneyWallet.getBalance(java.lang.String)
 * at matching regular expression /wallet. These two methods produces and
 * consumes exactly the same mime-types and therefore their invocation as a
 * resource methods will always fail)</i></li>
 * </ol>
 * 
 * @author bpawar
 *
 */
@Path("/wallet")
public interface MoneyEWallet {

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	String getBalance(@QueryParam("accountId") String accountId);
}
