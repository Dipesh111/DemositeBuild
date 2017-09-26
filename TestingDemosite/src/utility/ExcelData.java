package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public static File src;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh1;
	public static FileOutputStream fout;

	public ExcelData(String excelPath) {

		// To load the excel file from a location where it is saved.
		try {
			src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.print("Unable to find the excelfile path");
		}
	}
	// To write the data to excel sheet
	/*
	 * try { fout = new FileOutputStream(src); } catch (IOException e) {
	 * System.out.println("Unable to write an info to file"); }
	 */

	// To read the excel data with sheet number
	public static String getData(int sheetNumber, int row, int col) {
		sh1 = wb.getSheetAt(sheetNumber);
		// int totalRows = sh1.getLastRowNum();
		// int totalCol = wb.getSheetAt(sheetNumber).getLastRowNum();
		// System.out.println(totalRows+1);
		// System.out.println(totalCol+1);
		String data = sh1.getRow(row).getCell(col).getStringCellValue();
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	// To read the excel data with sheet name
	public static String getData(String sheetName, int row, int col) {
		sh1 = wb.getSheet(sheetName);
		String data = sh1.getRow(row).getCell(col).getStringCellValue();
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
 	}

	// To write the excel data
	public static void writeData(int sheetNumber, int row, int col, String typeValue)
			throws FileNotFoundException {
		sh1 = wb.getSheetAt(sheetNumber);
		sh1.getRow(row).createCell(col).setCellValue(typeValue);
		//writeDataToExcel(src);
		try {
			fout = new FileOutputStream(src);
			wb.write(fout);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeData(String sheetName, int row, int col, String typeValue)
			throws FileNotFoundException {
		sh1 = wb.getSheet(sheetName);
		sh1.getRow(row).createCell(col).setCellValue(typeValue);
		//writeDataToExcel(src);
		try {
			fout = new FileOutputStream(src);
			wb.write(fout);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*public static void writeDataToExcel(File src2)
			throws FileNotFoundException {
		try {
			fout = new FileOutputStream(src2);
			wb.write(fout);
		} catch (IOException e) {
			System.out.println("Unable to write data to file");
			e.printStackTrace();
		}
	}*/
	

}
