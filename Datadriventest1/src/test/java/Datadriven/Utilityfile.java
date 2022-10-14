package Datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class Utilityfile {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path=null;
	
	Utilityfile (String path)
	{
		this.path=path;
	}
public int getRowCount(String sheetname) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	int rowcount=sheet.getLastRowNum();
	workbook.close();
	fi.close();
	return rowcount;
}
public int getCellCount(String sheetname,int rownum) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rownum);
	int cellcount=row.getLastCellNum();
	workbook.close();
	fi.close();
	return cellcount;
}

public String getCellData(String sheetname,int rownum,int colnum) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rownum);
	cell=row.getCell(colnum);
	DataFormatter formatter=new DataFormatter();
	String data;
	try {
		data=formatter.formatCellValue(cell);
	}
	catch(Exception e)
	{data="";
	}
		workbook.close();
		fi.close();
		return data;
		
	}
	
}

/*public static void ReadExcelSheet() throws IOException
{
	String path=System.getProperty("user.dir")+"/src/test/resources/ExcelData/Demo.xlsx";
	File ExcelFile=new File(path);
	
	FileInputStream Fis=new FileInputStream(ExcelFile);
	XSSFWorkbook workbook=new XSSFWorkbook(Fis);
	XSSFSheet sheet=workbook.getSheet("Sheet 1");
	Iterator<Row> row=sheet.rowIterator();
	
	while(row.hasNext())
	{
		Row currow=row.next();
		Iterator<Cell> cell=currow.cellIterator();
		while(cell.hasNext())
		{
			Cell currcell=cell.next();
			System.out.print(currcell.getStringCellValue()+" ~ ");
		}
		System.out.println();
		
	}
	Row newRow=sheet.createRow(12);
	Cell newCell=newRow.createCell(13);
	newCell.setCellValue("Berni");
	FileOutputStream Fos=new FileOutputStream(ExcelFile);
	workbook.write(Fos);
	workbook.close();
}*/
