package org.first_project_gift_loft;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static String getSignInCredentials(int rowNum, int cellNum) throws IOException
	{
		String cellValue = null;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FirstProjectGiftLoft3\\ExcelFiles\\ExcelInputGivingFile.xlsx");
		
		Workbook w = new XSSFWorkbook(fis);
		
		Sheet s = w.getSheet("Sheet0");
		
		Row r = s.getRow(rowNum);
		
		Cell c = r.getCell(cellNum);
		
		int cellType = c.getCellType();
		
		if(cellType == 1)
		{
			cellValue = c.getStringCellValue();
		}
		
		else if(cellType == 0)
		{
			if(DateUtil.isCellDateFormatted(c))
			{
				Date dateValue = c.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
				cellValue = sdf.format(dateValue);
			}
			
			else
			{
				double d = c.getNumericCellValue();
				long l = (long) d;
				cellValue = String.valueOf(l);
			}
		}
			
		
		
		return cellValue;
		
	}

}
