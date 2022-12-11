package com.artoftesting.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DefinitionStorage {

    public static XSSFWorkbook wb;
    public static FileOutputStream fos;
    public static FileInputStream fis;
    public static String def_path = String.format(".//src//test//resources//DefinitionData//DefinitionStorage_%d.xlsx",
	    new Random().nextInt(3));

    public static void fn_createheader() throws Exception {

	fos = new FileOutputStream(def_path);
	wb = new XSSFWorkbook();
	XSSFSheet sheet = wb.createSheet("DEF-ATR");
	XSSFRow row = sheet.createRow(0);

	XSSFCell cell_1 = row.createCell(0);
	cell_1.setCellValue("Definition-Name");

	XSSFCell cell_2 = row.createCell(1);
	cell_2.setCellValue("Domain-Name");

	XSSFCell cell_3 = row.createCell(2);
	cell_3.setCellValue("Country-Name");

	XSSFCell cell_4 = row.createCell(3);
	cell_4.setCellValue("Description");

	wb.write(fos);
	wb.close();
	fos.close();

    }

    public static void fn_write(int defcount) throws Exception {

	fis = new FileInputStream(def_path);

	wb = new XSSFWorkbook(fis);

	XSSFSheet sheet = wb.getSheet("DEF-ATR");

	for (int i = 1; i <= defcount; i++) {
	    XSSFRow row = sheet.createRow(i);

	    XSSFCell defname = row.createCell(0);
	    defname.setCellValue("D" + Math.random());

	    XSSFCell domainname = row.createCell(1);
	    domainname.setCellValue("Automobile");

	    XSSFCell countryname = row.createCell(2);
	    countryname.setCellValue("India");

	    XSSFCell description = row.createCell(3);
	    description.setCellValue(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));

	}

	fis.close();

	fos = new FileOutputStream(def_path);
	wb.write(fos);
	wb.close();
	fos.close();
    }

}
