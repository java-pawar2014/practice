package org.restful.clientapi.accessor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CarAccessor {

	private static String BASE_URL = "http://localhost:8081/injection/api";

	public static void main(String[] args) {
		// pathParam("CITY-IVTEC", "Honda");
		// matrixParam("CITY-IVTEC", "Honda");
		// pathSegment("CITY-IVTEC", "Honda");
		uriInfo("CITY-IVTEC", "Honda");
	}

	private static void pathParam(String model, String manufacturer) {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(BASE_URL);
		target = target.path("/carwaale/{model}/{manufacturer}");
		target = target.resolveTemplate("model", model);
		target = target.resolveTemplate("manufacturer", manufacturer);
		target = target.path("/search");
		Invocation.Builder builder = target.request();
		Response response = builder.get();
		System.out.println(response.readEntity(String.class));
	}

	private static void matrixParam(String model, String manufacturer) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(BASE_URL);
		target = target.path("/carwaale/{model}/{manufacturer}");
		target = target.resolveTemplate("model", model);
		target = target.resolveTemplate("manufacturer", manufacturer);
		target = target.path("/searching");
		target = target.matrixParam("mfgYear", 2015);
		target = target.matrixParam("insurance", "NO");
		target = target.matrixParam("color", "RED");
		Response response = target.request(MediaType.TEXT_PLAIN_TYPE).get();
		System.out.println(response.readEntity(String.class));
	}

	private static void pathSegment(String model, String manufacturer) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(BASE_URL);
		target = target.path("/carwaale/{model}");
		target = target.resolveTemplate("model", model);
		target = target.matrixParam("mfgYear", 2012);
		target = target.matrixParam("insurance", "yes");
		target = target.matrixParam("color", "SILVER_GRAY");
		target = target.path("/{manufacturer}");
		target = target.resolveTemplate("manufacturer", manufacturer);
		target = target.matrixParam("mfgYear", 2015);
		target = target.matrixParam("insurance", "NO");
		target = target.matrixParam("color", "WHITE");
		target = target.path("/searchCars");
		Response response = target.request(MediaType.TEXT_PLAIN_TYPE).get();
		System.out.println(response.readEntity(String.class));
	}

	private static void uriInfo(String category, String brand) {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(BASE_URL);
		target = target.path("/car/seller/enquire/{category}").resolveTemplate("category", category)
				.matrixParam("fuelType", "PETROL").matrixParam("lowPrice", 590000).matrixParam("highPrice", 800000)
				.matrixParam("color", "GRAY").matrixParam("color", "WHITE");
		target = target.path("/{brand}").resolveTemplate("brand", brand).matrixParam("fuelType", "DIESEL")
				.matrixParam("lowPrice", 650000).matrixParam("highPrice", 1000000).matrixParam("color", "RED")
				.matrixParam("color", "BLACK");
		target = target.queryParam("fromMfgYear", 2010).queryParam("toMfgYear", 2018);
		Response response = target.request().get();
		System.out.println(response.readEntity(String.class));
	}

}
