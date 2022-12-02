package com.artoftesting.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginReadData {

    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static DataFormatter df = new DataFormatter();

    public static void fn_initialize(String excelfile) {
	try {
	    File file = new File(excelfile);
	    FileInputStream fis = new FileInputStream(file);
	    wb = new XSSFWorkbook(fis);

	}

	catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }

    public static int fn_getrowcount(int sheetIndex) {
	sheet = wb.getSheetAt(sheetIndex);
	int rowcount = sheet.getLastRowNum();
	return rowcount + 1;
    }

    public static int fn_getcellcount(int sheetIndex) {

	sheet = wb.getSheetAt(sheetIndex);
	XSSFRow row = sheet.getRow(2);
	return (row.getLastCellNum());
    }

    public static String fn_getdata(int sheetIndex, int row, int cell) {
	sheet = wb.getSheetAt(sheetIndex);
	String data = df.formatCellValue(sheet.getRow(row).getCell(cell)).toString();
	return data;
    }

}
