package com.sourcing.provider;

import java.io.FileInputStream;

import org.testng.TestRunner;
import org.testng.annotations.DataProvider;

import jxl.Cell;

/**
 * <b>Data provider for test all cases</b><br>
 * Reads the data from <code>xls</code> files and returns to {@link TestRunner}
 * 
 * @author nilesh
 * @author bpawar
 */
public class SourceDataProvider {

	public SourceDataProvider() {

	}

	/**
	 * Returns <code>array</code> of the city names, requested paginated pages and
	 * file name for the respective city
	 * 
	 * @return Array of sourcing information
	 */
	@DataProvider(name = "cities-data")
	public static String[][] getData() {

		String[][] retObjArr = getTableArray(ConfigReader.getConfigPropertyVal(Constants.TEST_DATA_FILE),
				ConfigReader.getConfigPropertyVal(Constants.TAB_NAME),
				ConfigReader.getConfigPropertyVal(Constants.TERMINATE_DATA_END));
		return (retObjArr);
	}

	/**
	 * Reads the excel file and returns array of sourcing data respective to the
	 * city, like city name, requested paginated pages and file name for sourcing.
	 * 
	 * @param xlFilePath
	 *            Source path of excel file
	 * @param sheetName
	 *            Name of the sheet to read data
	 * @param tableName
	 *            Name of the table
	 * @return
	 */
	public static String[][] getTableArray(String xlFilePath, String sheetName, String tableName) {
		String[][] tabArray = null;
		try {
			System.out.println("Read Work Book...");
			FileInputStream fis = new FileInputStream(xlFilePath);
			jxl.Workbook workbook = jxl.Workbook.getWorkbook(fis);
			jxl.Sheet sheet = workbook.getSheet(sheetName);
			System.out.println("Read Work Sheet...");

			Cell tableStart = sheet.findCell(tableName);
			int startRow = tableStart.getRow();
			int startCol = tableStart.getColumn();
			System.out.println("startRow=" + startRow + ",startCol=" + startCol);
			Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 2000, 1000, false);
			int endRow = tableEnd.getRow();
			int endCol = tableEnd.getColumn();
			System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol
					+ ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			int ci = 0;
			for (int i = startRow + 1; i < endRow; ci++) {
				int cj = 0;
				for (int j = startCol + 1; j < endCol; cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
					j++;
				}
				i++;
			}

		} catch (Exception e) {
			System.out.println("Error in reading file \"" + xlFilePath + "\".");
			e.printStackTrace();
		}
		return tabArray;
	}
}
