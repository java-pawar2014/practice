package org.restful.clientapi.accessor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BillingInfoAccessor {

	private static final String BASE_URL = "http://localhost:8081/injection/api/billing";

	public static void main(String[] args) {
		queryParam(12512, "CUST451415584");
	}

	private static void queryParam(int billNo, String customerId) {
		Client clientInvoker = ClientBuilder.newBuilder().build();

		WebTarget targetUrl = clientInvoker.target(BASE_URL);
		// paths
		targetUrl = targetUrl.path("/individual");
		// Query params
		targetUrl = targetUrl.queryParam("billNo", billNo);
		targetUrl = targetUrl.queryParam("customerId", customerId);

		Invocation.Builder targetInvoker = targetUrl.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = targetInvoker.get();
		String responseBody = response.readEntity(String.class);
		System.out.println(responseBody);
		System.out.println(response.getStatus());
	}
}
