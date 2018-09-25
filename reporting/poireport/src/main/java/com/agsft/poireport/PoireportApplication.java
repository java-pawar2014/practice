package com.agsft.poireport;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.agsft.poireport.dto.ContactDTO;

@SpringBootApplication
public class PoireportApplication {

	private static String[] columns = { "First Name", "Last Name", "Email", "Date Of Birth" };
	private static List<ContactDTO> contacts = new ArrayList<ContactDTO>();

	private static int rowCount = 0;

	public static void main(String[] args) throws IOException, InvalidFormatException {
		contacts.add(new ContactDTO("Sylvain", "Saurel", "sylvain.saurel@gmail.com", "17/01/1980"));
		contacts.add(new ContactDTO("Albert", "Dupond", "sylvain.saurel@gmail.com", "17/08/1989"));
		contacts.add(new ContactDTO("Pierre", "Dupont", "sylvain.saurel@gmail.com", "17/07/1956"));
		contacts.add(new ContactDTO("Mariano", "Diaz", "sylvain.saurel@gmail.com", "17/05/1988"));

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Contacts");
		sheet.setHorizontallyCenter(true);
		sheet.setVerticallyCenter(true);
		Font titleFont = workbook.createFont();
		titleFont.setBold(true);
		titleFont.setFontHeightInPoints((short) 13);
		titleFont.setColor(IndexedColors.BLACK.getIndex());

		Font subTitleFont = workbook.createFont();
		subTitleFont.setBold(true);
		subTitleFont.setFontHeightInPoints((short) 12);
		subTitleFont.setColor(IndexedColors.BLACK.getIndex());

		CellStyle titleCellStyle = workbook.createCellStyle();
		titleCellStyle.setFont(titleFont);
		titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
		titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		CellStyle subTitleCellStyle = workbook.createCellStyle();
		subTitleCellStyle.setFont(subTitleFont);

		CellStyle leftAlignCellStyle = workbook.createCellStyle();
		leftAlignCellStyle.setFont(subTitleFont);
		leftAlignCellStyle.setAlignment(HorizontalAlignment.LEFT);
		leftAlignCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// Create a Row
		Row headerRow = sheet.createRow(rowCount); // 0
		headerRow.setRowStyle(titleCellStyle);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("WAAS Audit Report");
		sheet.addMergedRegion(new CellRangeAddress(rowCount, ++rowCount, 0, 3));// 1
		Row blankRow = sheet.createRow(++rowCount);// 2
		Cell blankCell = blankRow.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 0, 3));

		headerMenuRowCreator(sheet, leftAlignCellStyle, "Event Name", "Some Event Name");
		headerMenuRowCreator(sheet, leftAlignCellStyle, "Event Address", "Some Event Address");
		headerMenuRowCreator(sheet, leftAlignCellStyle, "Event Date and Time", "Some Event Date and Time");

		Row headerRow1 = sheet.createRow(++rowCount);// 4

		for (int i = 0; i < columns.length; i++) {
			Cell cell1 = headerRow1.createCell(i);
			cell1.setCellValue(columns[i]);
			cell1.setCellStyle(subTitleCellStyle);
		}

		// Create Other rows and cells with contacts data
		int rowNum = ++rowCount;

		for (ContactDTO contact : contacts) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(contact.firstName);
			row.createCell(1).setCellValue(contact.lastName);
			row.createCell(2).setCellValue(contact.email);
			row.createCell(3).setCellValue(contact.dateOfBirth);
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("contacts.xlsx");
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
		System.out.println("Workbook created");
	}

	private static void headerMenuRowCreator(Sheet sheet, CellStyle cellStyle, String title, String value) {
		Row eventTimestampRow = sheet.createRow(++rowCount);// 5
		eventTimestampRow.setRowStyle(cellStyle);
		Cell eventTimestampTitleCell = eventTimestampRow.createCell(0);
		eventTimestampTitleCell.setCellValue(title);
		Cell eventTimestampValueCell = eventTimestampRow.createCell(2);
		eventTimestampValueCell.setCellValue(value);
		sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 2, 3));
	}
}
