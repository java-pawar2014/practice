package com.agsft.orgchart.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

/**
 * @author bpawar
 *
 */
@Component
public class Reader {

	private SimpleDateFormat dateFormat;

	public Reader() {
		dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	}

	public List<Map<String, String>> getCsvFileLines(InputStream inputStream) throws IOException {

		return readCsvFileLines(inputStream);
	}

	public List<Map<String, String>> readCsvFileLines(InputStream inputStream) throws IOException {
		List<Map<String, String>> rows = null;
		java.io.Reader in = new InputStreamReader(inputStream);
		CSVParser records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		Map<String, Integer> headerMap = records.getHeaderMap();
		rows = new ArrayList<Map<String, String>>();
		for (CSVRecord record : records) {
			Map<String, String> columns = new HashMap<String, String>();
			for (String key : headerMap.keySet()) {
				String cellValue = record.get(key);
				columns.put(key, cellValue);
			}
			rows.add(columns);
		}
		return rows;
	}

	public <T> List<T> mapper(List<Map<String, String>> mappingData, Class<T> type) throws Exception {
		List<T> list = new ArrayList<T>();

		for (Map<String, String> rows : mappingData) {
			T t = type.newInstance();
			Method[] methods = t.getClass().getDeclaredMethods();
			for (String key : rows.keySet()) {
				for (Method method : methods) {
					String methodName = method.getName();
					if (methodName.startsWith("set") && methodName.contains(key.substring(1, key.length()))) {
						String cellValue = rows.get(key);
						if (cellValue.isEmpty()) {
							// method.invoke(t, cellValue);
						} else {
							if (cellValue.matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$")) {
								try {
									method.invoke(t, dateFormat.parse(cellValue));
								} catch (ParseException e) {
								}
							} else if (cellValue.matches("^\\d+$") && cellValue.length() > 8) {
								method.invoke(t, Long.parseLong(cellValue));
							} else if (cellValue.matches("^\\d+$")) {
								method.invoke(t, Integer.parseInt(cellValue));
							} else if (cellValue.matches("true") || cellValue.matches("false")
									|| cellValue.matches("TRUE") || cellValue.matches("FALSE")) {
								method.invoke(t, Boolean.parseBoolean(cellValue));
							} else {
								method.invoke(t, cellValue);
							}
						}
						break;
					}
				}
			}
			list.add(t);
		}
		return list;
	}

//	public static void main(String[] args) throws Throwable {
//		Reader reader = new Reader();
//		File file = new File("/home/bpawar/Downloads/chart2.csv");
//		List<Map<String, String>> lines = reader.getCsvFileLines(new FileInputStream(file));
//
//		List<EmployeeDTO> employees = reader.mapper(lines, EmployeeDTO.class);
//		for (EmployeeDTO employee : employees)
//			System.out.println(employee);
//	}
}
