package com.atmecs.openmrs.testdata;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	String filePath;

	public ExcelData(String filePath) {
		this.filePath = filePath;
	}

	public Object[][] readExcelData(String sheetName) throws IOException {
		Object[][] data;
		XSSFWorkbook workbook;
		workbook = new XSSFWorkbook(this.filePath);
		XSSFSheet sh = workbook.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();

		int columnCount = sh.getRow(0).getLastCellNum();
		data = new Object[rowCount][columnCount];
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			int cellCount = sh.getRow(rowIndex).getLastCellNum();

			for (int colIndex = 0; colIndex < cellCount; colIndex++) {
				String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				data[rowIndex - 1][colIndex] = value;
			}
		}
		workbook.close();
		return data;

	}

}
