package org.restful.serverresponse.adapter;

import java.util.Date;

import javax.json.bind.adapter.JsonbAdapter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.restful.serverresponse.util.StringDateUtility;

public class JsonXmlDateTimeAdapter extends XmlAdapter<String, Date> implements JsonbAdapter<Date, String> {

	public JsonXmlDateTimeAdapter() {

	}

	@Override
	public Date adaptFromJson(String source) throws Exception {
		System.out.println("JsonXmlDateTimeAdapter.adaptFromJson-string to date");
		return StringDateUtility.stringToDate(source);
	}

	@Override
	public String adaptToJson(Date date) throws Exception {
		System.out.println("JsonXmlDateTimeAdapter.adaptToJson-date to string");
		return StringDateUtility.dateToString(date);
	}

	@Override
	public String marshal(Date date) throws Exception {
		System.out.println("JsonXmlDateTimeAdapter.marshal-date to string");
		return StringDateUtility.dateToString(date);
	}

	@Override
	public Date unmarshal(String source) throws Exception {
		System.out.println("JsonXmlDateTimeAdapter.unmarshal-string to date");
		return StringDateUtility.stringToDate(source);
	}
}
