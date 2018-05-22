package com.agsft.orgchart.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.agsft.orgchart.enums.ColumnHeader;

/**
 * @author bpawar
 *
 */
@Component
public class Reader {

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public List<Map<String, String>> getCsvFileLines(File file) throws IOException {

		return readCsvFileLines(file);
	}

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	protected List<Map<String, String>> readCsvFileLines(File file) throws IOException {
		List<Map<String, String>> rows = null;
		java.io.Reader in = new FileReader(file);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		rows = new ArrayList<Map<String, String>>();
		for (CSVRecord record : records) {
			Map<String, String> columns = new HashMap<String, String>();
			columns.put(ColumnHeader.EMPLOYEE_ID.name(), record.get(ColumnHeader.EMPLOYEE_ID.name()));
			columns.put(ColumnHeader.FIRST_NAME.name(), record.get(ColumnHeader.FIRST_NAME.name()));
			columns.put(ColumnHeader.LAST_NAME.name(), record.get(ColumnHeader.LAST_NAME.name()));
			columns.put(ColumnHeader.EMAIL.name(), record.get(ColumnHeader.EMAIL.name()));
			columns.put(ColumnHeader.PHONE.name(), record.get(ColumnHeader.PHONE.name()));
			columns.put(ColumnHeader.DOJ.name(), record.get(ColumnHeader.DOJ.name()));
			columns.put(ColumnHeader.ROLE_ID.name(), record.get(ColumnHeader.ROLE_ID.name()));
			columns.put(ColumnHeader.BOSS_ID.name(), record.get(ColumnHeader.BOSS_ID.name()));
			columns.put(ColumnHeader.DEPARTMENT_ID.name(), record.get(ColumnHeader.DEPARTMENT_ID.name()));
			columns.put(ColumnHeader.COST.name(), record.get(ColumnHeader.COST.name()));
			rows.add(columns);
		}
		return rows;
	}

	// public static void main(String[] args) throws IOException, ParseException
	// {
	// Reader reader = new Reader();
	// File file = new File("/home/bpawar/Downloads/chart2.csv");
	// List<Map<String, String>> lines = reader.getCsvFileLines(file);
	// int count = 1;
	// for (Map<String, String> line : lines) {
	// System.out.println("\nLine : " + count++);
	// for (String key : line.keySet()) {
	// if (key.equalsIgnoreCase("DOJ"))
	// System.out.println(new
	// SimpleDateFormat("dd/MM/yy").parse(line.get(key)));
	// else
	// System.out.println(key + " : " + line.get(key));
	// }
	// }
	// }
}
