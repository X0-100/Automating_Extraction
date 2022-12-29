package com.artoftesting.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.netty.util.internal.ThreadLocalRandom;

public class ServiceStorage {

    public static FileOutputStream fos;
    public static FileInputStream fis;

    /*
     * public static int randomnumfile = ThreadLocalRandom.current().nextInt(3, 5 +
     * 1);
     */

    public static String servicefileread = ".//src//test//resources//ServiceData//ServiceStorageREAD.xlsx";
    public static String servicefilewrite = ".//src//test//resources//ServiceData//ServiceStorageWRITE.xlsx";

    public static void fn_createheader() throws IOException {

	fos = new FileOutputStream(servicefileread);
	XSSFWorkbook wb = new XSSFWorkbook();
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

    public static void fn_write(int servicecount, String servicetype, String sleep, String appserver,
	    String appserverurl, String port, String cabinetname, String username, String password, String queuename,
	    String engine) throws Exception {

	fos = new FileOutputStream(servicefilewrite);
	fis = new FileInputStream(servicefileread);

	XSSFWorkbook wbheader = new XSSFWorkbook(fis);
	XSSFSheet wbsheetread = wbheader.getSheetAt(0);

	XSSFWorkbook wbwr = new XSSFWorkbook();
	XSSFSheet sheetService = wbwr.createSheet("ServiceManage");

	XSSFRow rowhedaer = sheetService.createRow(0);

	for (int x = 0; x < wbheader.getSheetAt(0).getRow(0).getLastCellNum(); x++) {

	    String headerwrite = wbsheetread.getRow(0).getCell(x).getStringCellValue();
	    XSSFCell cellheader = rowhedaer.createCell(x);
	    cellheader.setCellValue(headerwrite);
	}

	for (int row = 1; row <= servicecount; row++) {

	    int randomnum = ThreadLocalRandom.current().nextInt(4, 5 + row);

	    XSSFRow rowsvc = sheetService.createRow(row);

	    XSSFCell cell_1 = rowsvc.createCell(0);
	    cell_1.setCellValue("Service-Name" + String.valueOf(randomnum));

	    XSSFCell cell_2 = rowsvc.createCell(1);
	    cell_2.setCellValue(servicetype);

	    XSSFCell cell_3 = rowsvc.createCell(2);
	    cell_3.setCellValue(sleep);

	    XSSFCell cell_4 = rowsvc.createCell(3);
	    cell_4.setCellValue(appserver);

	    XSSFCell cell_5 = rowsvc.createCell(4);
	    cell_5.setCellValue(appserverurl);

	    XSSFCell cell_6 = rowsvc.createCell(5);
	    cell_6.setCellValue(port);

	    XSSFCell cell_7 = rowsvc.createCell(6);
	    cell_7.setCellValue(cabinetname);

	    XSSFCell cell_8 = rowsvc.createCell(7);
	    cell_8.setCellValue(username);

	    XSSFCell cell_9 = rowsvc.createCell(8);
	    cell_9.setCellValue(password);

	    XSSFCell cell_10 = rowsvc.createCell(9);
	    cell_10.setCellValue(queuename);

	    XSSFCell cell_11 = rowsvc.createCell(10);
	    cell_11.setCellValue(engine);

	}

	wbheader.close();
	fis.close();

	wbwr.write(fos);
	wbwr.close();
	fos.close();

    }

}
