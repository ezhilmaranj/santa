package com.logica.srtracker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.logica.srtracker.data.ServiceRequest;

public class ExcelParser {
	
	public List<ServiceRequest> excelToList(File file) throws IOException{
		Logger log = Logger.getLogger(this.getClass());
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook workBook = new HSSFWorkbook(fis);
		HSSFSheet workSheet = workBook.getSheet("Sheet1");
		
		List<ServiceRequest> serviceRequestList = new ArrayList<ServiceRequest>();
		Date date = new Date();
		int count=0;
		for (Row row : workSheet) {
			if(row.getRowNum()!=0){
				ServiceRequest serviceRequest = new  ServiceRequest();
				serviceRequest.setSrNumber(row.getCell(0).getStringCellValue());
				serviceRequest.setCreatedDate(date);
				serviceRequest.setCommitedDate(date);
				serviceRequest.setWrefrenceNumber(row.getCell(3).getStringCellValue());
				serviceRequest.setRequestType(row.getCell(4).getStringCellValue());
				serviceRequest.setCustomerName(row.getCell(5).getStringCellValue());
				serviceRequest.setCategory("HAVE TO UPDATE");
				serviceRequest.setBoltStatus("HAVE TO UPDATE");
				serviceRequest.setSrStatus("OPEN");
				serviceRequest.setSrComments("HAVE TO UPDATE");
				serviceRequest.setReviewDate(date);
				serviceRequest.setUpdatedOn(date);
				serviceRequest.setUserInfo(null);
				serviceRequestList.add(serviceRequest);
				count ++;
			}
			System.out.println("Total SR : "+count);
			
			
			
/*			for (Cell cell : row) {
				 
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					serviceRequest.setSrNumber(cell.getStringCellValue());
					System.out.println(cell.getStringCellValue() + " ");
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.println(cell.getDateCellValue());
					break;

				default:
					System.out.println(cell.getDateCellValue());
					break;
				}
			}
			System.out.println();*/
		}
		log.debug(serviceRequestList);
		
		return serviceRequestList;
	}

	public static void main(String[] args) throws IOException,
			InvalidFormatException {
		File f = new File("E:\\SR.xls");

		/*
		 * FileInputStream fis = new FileInputStream(f); Workbook wb =
		 * WorkbookFactory.create(fis); Sheet sheet = wb.getSheet("Sheet1");
		 * 
		 * for (HSSFRow row : sheet) { for (HSSFCell cell : row) {
		 * 
		 * switch (cell.getCellType()) {
		 * 
		 * case Cell.CELL_TYPE_STRING:
		 * System.out.println(cell.getStringCellValue() + "  "); break;
		 * 
		 * case Cell.CELL_TYPE_NUMERIC: System.out.println("dsds");
		 * System.out.println(cell.getNumericCellValue()+ "  ");
		 * System.out.println(new Date(new Double(cell
		 * .getNumericCellValue()).toString())); break;
		 * 
		 * default: System.out.println(new Date(new Double(cell
		 * .getNumericCellValue()).toString())); break; } }
		 * System.out.println(); }
		 */

		FileInputStream fis = new FileInputStream(f);

		HSSFWorkbook workBook = new HSSFWorkbook(fis);
		HSSFSheet workSheet = workBook.getSheet("Sheet1");

		for (Row row : workSheet) {
			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getStringCellValue() + " ");
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.println(cell.getDateCellValue());
					break;

				default:
					System.out.println(cell.getDateCellValue());
					break;
				}
			}
			System.out.println();
		}

		/*
		 * XSSFWorkbook book = new XSSFWorkbook(fis); XSSFSheet sheet =
		 * book.getSheet("Sheet1"); for (Row row : sheet) { for (Cell cell :
		 * row) { switch (cell.getCellType()) { case Cell.CELL_TYPE_STRING:
		 * System.out.println(cell.getStringCellValue() + " "); break; case
		 * Cell.CELL_TYPE_NUMERIC: System.out.println(cell.getDateCellValue());
		 * break;
		 * 
		 * default: System.out.println(cell.getDateCellValue()); break; } }
		 * System.out.println(); }
		 */
	}
}
