package testUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFileData {
	
	public static String fetchDataFromExcel(int row,int cell) throws IOException {
	String data="";
	
	String path="C"+File.separator+"Users"+File.separator+"paras"+File.separator+"Desktop"+File.separator+"Book1.xlsx";
	FileInputStream file=new FileInputStream(path);
	
	Sheet s=WorkbookFactory.create(file).getSheet("Velocity");
	
	Cell c=s.getRow(row).getCell(cell);
	CellType type=c.getCellType();
    
	if (type==CellType.STRING)
	{
		data=c.getStringCellValue();
	}
	else if(type==CellType.NUMERIC)
	{
		double number=c.getNumericCellValue();
		data=String.valueOf(number);
		data=Double.toString(number);
	}
	else if (type==CellType.BLANK)
	{
		data="";
	}
	return data;

}
}
