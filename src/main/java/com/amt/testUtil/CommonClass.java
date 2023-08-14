package com.amt.testUtil;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.amt.testBase.TestBase;

public class CommonClass extends TestBase {
	
	Properties prop;	
	
	public CommonClass() {
		try {
			// Properties class object initialization
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\Acquisition_Edit\\AMT_Acquisition_Edit\\src\\main\\java\\configs\\excelValues.properties");
			// load property file
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String validate_selected_order(WebElement element) {
		ExplicitWait.visibleElement(driver, element, 60);

		return element.getText().trim();
	}
	

	public boolean check_refresh_link_available(WebElement refresh_link, WebElement tab, String quote_no) {

		boolean refresh_link_exists = false;
		try {
			ExplicitWait.visibleElement(driver, refresh_link, 20);

			refresh_link_exists = true;

			ExplicitWait.visibleElement(driver, tab, 20);

			System.out.println("Refresh Link is available on " + tab.getText() + " for quote no. " + quote_no);
			LO.print("Refresh Link is available on " + tab.getText() + " for quote no. " + quote_no);

		} catch (Exception e) {

			ExplicitWait.visibleElement(driver, tab, 20);

			System.out.println("Refresh Link is not available on " + tab.getText() + " for quote no. " + quote_no);
			LO.print("Refresh Link is not available on " + tab.getText() + " for quote no. " + quote_no);

			System.exit(1);

		}

		return refresh_link_exists;
	}

	public void write_quote_no_and_error_message_to_excel_sheet(String Quote_Ref_no, int column_no) throws IOException {

		System.err.println("Writing Error Message to Excel Sheet");
		
		String sheet_name = prop.getProperty("Quote_no_and_error_messages");

		FileInputStream in = new FileInputStream(prop.getProperty("refresh_link_error_message_excel_path"));
		XSSFWorkbook wb = new XSSFWorkbook(in);

		XSSFSheet sheet = wb.getSheet(sheet_name);

		int lastRowNum = sheet.getLastRowNum();

		Row row = sheet.createRow(lastRowNum + 1);

		Cell refNoCell = row.createCell(0);

		refNoCell.setCellValue(Quote_Ref_no);

		Cell errorCell = row.createCell(column_no);

		XSSFFont font = wb.createFont();
		
		font.setColor(IndexedColors.RED.getIndex()); // Set the color to red
		
		CellStyle style = wb.createCellStyle();
		
		style.setFont(font);

		errorCell.setCellValue("Refresh Link is not worked");
		
		System.err.println("Excel sheet writing completed");

		FileOutputStream out = new FileOutputStream(prop.getProperty("formula_excel_path"));
		wb.write(out);

	}

}
