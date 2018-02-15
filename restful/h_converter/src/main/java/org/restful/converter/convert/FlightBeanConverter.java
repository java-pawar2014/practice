package org.restful.converter.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ParamConverter;

import org.restful.converter.bean.FlightBean;

public class FlightBeanConverter implements ParamConverter<FlightBean> {

	private DateFormat formatDate;

	public FlightBeanConverter() {
		formatDate = new SimpleDateFormat("dd/MM/yyyy");
	}

	@Override
	public FlightBean fromString(String data) {
		FlightBean flightBean = null;
		String[] values = data.split(",");
		flightBean = new FlightBean();

		for (String value : values) {
			if (value.startsWith("flightCode=")) {
				flightBean.setFlightCode(value.split("=")[1]);
			} else if (value.startsWith("sourceAirport=")) {
				flightBean.setSourceAirport(value.split("=")[1]);
			} else if (value.startsWith("destAirport=")) {
				flightBean.setDestAirport(value.split("=")[1]);
			} else if (value.startsWith("departDate=")) {
				try {
					flightBean.setDepartDate(formatDate.parse(value.split("=")[1]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return flightBean;
	}

	@Override
	public String toString(FlightBean value) {

		return value.toString();
	}

}
