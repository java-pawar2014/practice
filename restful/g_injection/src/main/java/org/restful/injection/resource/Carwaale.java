package org.restful.injection.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

import org.restful.injection.util.URIExtractor;

/**
 * The resources talks about matrix params along with path params. The matrix
 * params are always optional
 * 
 * @author bpawar
 *
 */
@Path("/carwaale/{model}/{manufacturer}")
public class Carwaale extends URIExtractor {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/search")
	public String search(@PathParam("model") String model, @PathParam("manufacturer") String manufacturer) {

		return "Model: " + model + " Manufacturer: " + manufacturer;

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/searching")
	public String searching(@PathParam("model") String model, @PathParam("manufacturer") String manufacturer,
			@DefaultValue("2010") @MatrixParam("mfgYear") int mfgYear,
			@DefaultValue("No") @MatrixParam("insurance") String insurance,
			@DefaultValue("White") @MatrixParam("color") String color) {

		return "Model: " + model + " Manufacturer: " + manufacturer + " Mfg Year: " + mfgYear + " Insurance: "
				+ insurance + " Color: " + color;

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/searchCars")
	public String searchingCars(@PathParam("model") PathSegment modelSegment,
			@PathParam("manufacturer") PathSegment manufacturerSegment) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("Model : ").append(modelSegment.getPath());
		buffer.append("\n\tMatrix Params: ");
		buffer.append(extractMap(modelSegment.getMatrixParameters()));

		buffer.append("\nManuf : ").append(manufacturerSegment.getPath());
		buffer.append("\n\tMatrix Params: ");
		buffer.append(extractMap(manufacturerSegment.getMatrixParameters()));

		return buffer.toString();
	}
}
