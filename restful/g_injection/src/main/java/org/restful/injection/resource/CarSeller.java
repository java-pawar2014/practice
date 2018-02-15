package org.restful.injection.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.restful.injection.util.URIExtractor;

/**
 * The resource talks about the complete request URI. The {@link UriInfo} holds
 * all data of the request URI.<br>
 * The resource states the use of {@link Context} for the injection of
 * {@link UriInfo} and {@link HttpHeaders}.<br>
 * The resource also states use of {@link CookieParam} for injecting the
 * respective cookies.
 * 
 * @author bpawar
 *
 */
@Path(value = "/car/seller")
public class CarSeller extends URIExtractor {

	/**
	 * This method takes input as {@link UriInfo} which holds the whole URI
	 * information from which we can retrieve the required details.<br>
	 * This method returns Path parameters, Query parameters and Matrix
	 * parameters associated with respective to {@link PathSegment}.
	 * 
	 * @param info
	 *            holds the whole URI information
	 * @return returns {@link String} of all type of parameters
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/enquire/{category}/{brand}")
	public String search(@Context UriInfo uriInfo) {

		MultivaluedMap<String, String> queryParams = null;
		MultivaluedMap<String, String> pathParams = null;
		List<PathSegment> pathSegments = null;
		StringBuilder response = null;

		queryParams = uriInfo.getQueryParameters();
		pathParams = uriInfo.getPathParameters();
		pathSegments = uriInfo.getPathSegments();

		response = new StringBuilder();

		response.append("Query Params : ");
		response.append(extractMap(queryParams));

		response.append("\nPath params : ");
		response.append(extractMap(pathParams));

		response.append("\nMatrix params");

		for (PathSegment segment : pathSegments) {
			response.append("\n\tPath: " + segment.getPath());
			MultivaluedMap<String, String> matrixParams = segment.getMatrixParameters();
			if (matrixParams.isEmpty())
				response.append("\tNo matrix params");
			else
				response.append("\n\t\tMatrix params: ").append(extractMap(matrixParams));
		}
		return response.toString();
	}

	/**
	 * This method uses {@link @Context} for {@link HttpHeaders} which gives all
	 * headers of the HTTP request.
	 * 
	 * @param fromMonth
	 *            starting month for report generation, provided by user
	 * @param toMonth
	 *            ending month for report generation, provided by user
	 * @param headers
	 *            contains all headers of request, injected by JAX-RS Runtime
	 * @return returns report generation status
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/report/{fromMonth}/{toMonth}")
	public String getReport(@PathParam("fromMonth") String fromMonth, @PathParam("toMonth") String toMonth,
			@Context HttpHeaders headers) {

		MultivaluedMap<String, String> headersMap = null;
		StringBuilder response = null;

		headersMap = headers.getRequestHeaders();
		response = new StringBuilder();

		if (headersMap.containsKey("username")) {
			response.append("User found : " + headersMap.getFirst("username")).append("\n");
			response.append("The report you requested from month ").append(fromMonth).append(" to ").append(toMonth)
					.append(" will be send shortly.");

		} else {
			response.append("User not found. Failed to genarate report.");
			response.append("Header is not found : username");
		}
		return response.toString();
	}

	/**
	 * This method takes {@link CookieParam} and {@link PathParam} as inputs.
	 * The JAX-RS Runtime injects the specified cookie into {@link CookieParam}
	 * attribute if found.
	 * 
	 * @param username
	 *            must be injected by using {@link CookieParam} from available
	 *            cookies
	 * @param password
	 *            must be injected by using {@link PathParam} from the request
	 *            URI
	 * @return simply returns {@link String} of {@link CookieParam} and
	 *         {@link PathParam}
	 */

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getCookie/{username}")
	public String getCookie(@CookieParam("password") String password, @PathParam("username") String username) {

		return new StringBuilder().append("Username : ").append(username).append(" Password : ").append(password)
				.toString();
	}

	/**
	 * This method creates cookie using {@link NewCookie} and builds it upon
	 * invocation and returns to browser as {@link Response}
	 * 
	 * @return cookie as {@link Response} as key and value
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	@GET
	@Path("/createCookie")
	public Response createCookie() {

		NewCookie cookie = new NewCookie(new Cookie("username", "root"), "Sample cookie generated by JAX-RS", 10,
				new Date(2018, 2, 8), true, true);

		// return Response.ok().cookie(cookie).build();
		return Response.ok().cookie(new NewCookie("username", "root")).build();
	}
}
