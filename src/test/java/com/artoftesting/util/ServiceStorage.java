package com.artoftesting.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.bytebuddy.utility.RandomString;

public class ServiceStorage {

    public static FileOutputStream fos;
    public static FileInputStream fis;
    public static XSSFWorkbook wb;
    public static String somerandomappender = new RandomString().nextString();
    public static String servicefile = String.format(".//src//test//resources//DefinitionData//ServiceStorage_%s.xlsx",
	    somerandomappender);

    public static void fn_createheader() throws IOException {

	fos = new FileOutputStream(servicefile);
	wb = new XSSFWorkbook();
	XSSFSheet sheet = wb.createSheet("Service_Input");
	XSSFRow row = sheet.createRow(0);

	XSSFCell cell_1 = row.createCell(0);
	cell_1.setCellValue("Service-Name");

	XSSFCell cell_2 = row.createCell(1);
	cell_2.setCellValue("Service-Type");

	XSSFCell cell_3 = row.createCell(2);
	cell_3.setCellValue("Sleep-Interval");

	XSSFCell cell_4 = row.createCell(3);
	cell_4.setCellValue("App-Server-Type");

	XSSFCell cell_5 = row.createCell(4);
	cell_5.setCellValue("App-Server-URL");

	XSSFCell cell_6 = row.createCell(5);
	cell_6.setCellValue("App-Server-Port");

	XSSFCell cell_7 = row.createCell(6);
	cell_7.setCellValue("Cabinet-Name");

	XSSFCell cell_8 = row.createCell(7);
	cell_8.setCellValue("User-Name");

	XSSFCell cell_9 = row.createCell(8);
	cell_9.setCellValue("Password");

	XSSFCell cell_10 = row.createCell(9);
	cell_10.setCellValue("Queue-Name");

	XSSFCell cell_11 = row.createCell(10);
	cell_11.setCellValue("Engine");

	wb.write(fos);
	wb.close();
	fos.close();

    }

    public static void fn_write(int servicecount, String servicetype, int sleep, String appserver, String appserverurl,
	    int port, String cabinetname, String username, String password, String queuename, String engine)
	    throws Exception {
	fis = new FileInputStream(servicefile);
	fos = new FileOutputStream(servicefile);
	XSSFWorkbook wb = new XSSFWorkbook(fis);

	for (int x = 1; x <= servicecount; x++) {
	    wb.getSheetAt(0).getRow(x).createCell(0)
		    .setCellValue(String.format("SERVICE_%d", new RandomString().nextString()));
	    wb.getSheetAt(0).getRow(x).createCell(1).setCellValue(servicetype);
	    wb.getSheetAt(0).getRow(x).createCell(2).setCellValue(sleep);
	    wb.getSheetAt(0).getRow(x).createCell(3).setCellValue(appserver);
	    wb.getSheetAt(0).getRow(x).createCell(2).setCellValue(appserverurl);
	    wb.getSheetAt(0).getRow(x).createCell(2).setCellValue(port);
	    wb.getSheetAt(0).getRow(x).createCell(2).setCellValue(cabinetname);
	    wb.getSheetAt(0).getRow(x).createCell(2).setCellValue(username);
	    wb.getSheetAt(0).getRow(x).createCell(2).setCellValue(password);
	    wb.getSheetAt(0).getRow(x).createCell(2).setCellValue(queuename);
	    wb.getSheetAt(0).getRow(x).createCell(2).setCellValue(engine);
	}
	fis.close();
	wb.write(fos);
	wb.close();
	fos.close();

    }

}
