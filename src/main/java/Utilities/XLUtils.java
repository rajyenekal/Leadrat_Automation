package Utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	private Sheet sheet;
	private Map<String, Integer> headerMap;
	private String specifiedHeader;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sht;



    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        FileInputStream fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sht = workbook.getSheet(xlSheet);
        int rowCount = sht.getLastRowNum();
        workbook.close();
        fis.close();
        return rowCount;
    }

    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
        FileInputStream fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sht = workbook.getSheet(xlSheet);
        Row row = sht.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fis.close();
        return cellCount;
    }

    public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        FileInputStream fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sht = workbook.getSheet(xlSheet);
        XSSFRow row = sht.getRow(rowNum);
        XSSFCell cell = row.getCell(colNum);

        String data;
        try {
            if (cell == null) {
                data = "";
            } else if (cell.getCellType() == CellType.STRING)
                data = cell.getStringCellValue();
            else if (cell.getCellType() == CellType.NUMERIC)
                data = String.valueOf((int) cell.getNumericCellValue());
            else
                data = "";
        } catch (Exception e) {
            data = "";
        }
        workbook.close();
        fis.close();
        return data;
    }
	  

	    public void ExcelUtil(String specifiedHeader) throws IOException {
			String path=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\leadRat_testdata.xlsx";
	        FileInputStream file = new FileInputStream(path);
	        Workbook workbook = WorkbookFactory.create(file);
	        this.sheet = workbook.getSheetAt(0);
	        this.headerMap = new HashMap<>();
	        this.specifiedHeader = specifiedHeader;
	        loadHeader();
	        workbook.close();
	        file.close();
	    }

	    private void loadHeader() {
	        Row headerRow = sheet.getRow(0);
	        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
	            String header = headerRow.getCell(i).getStringCellValue();
	            headerMap.put(header, i);
	        }
	    }

	    public String getData(int rowNum) {
	        DataFormatter formatter = new DataFormatter();
	        Row row = sheet.getRow(rowNum);
	        int colNum = headerMap.get(specifiedHeader);
	        return formatter.formatCellValue(row.getCell(colNum));
	    }
}

