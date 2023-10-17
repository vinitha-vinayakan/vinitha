package com.vinitha.requestgeneration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
private XSSFWorkbook workbook=null;
private File outputFile=null;
	
	public void openWorkBook(String file) throws EncryptedDocumentException, IOException {
		
		File  worksheetsFile=new File("src/main/resources/excel sheets", file+".xlsx");
		Path path= Files.copy(worksheetsFile.toPath(),File.createTempFile(file,".xlsx").toPath(),
				StandardCopyOption.REPLACE_EXISTING);
		outputFile=path.toFile();
		//outputFile.deleteOnExit();
        workbook= (XSSFWorkbook)WorkbookFactory
    		   .create(new FileInputStream(outputFile));	                                                                                                                                                                                                   
	}
	public XSSFSheet getsheeet( int sheetNumber) throws EncryptedDocumentException, IOException {
		
		return workbook.getSheetAt(sheetNumber);
		
	}
    public void output() throws IOException {
    	
    	FileOutputStream outputStream=new FileOutputStream(outputFile);
    	workbook.write(outputStream);
    }
   public XSSFCell createMyCell(XSSFRow row,int column) {
	  XSSFCell cell=null;
	  XSSFCellStyle cellStyle=workbook.createCellStyle();
	  cellStyle.setBorderBottom(BorderStyle.THIN);
	  cellStyle.setBorderLeft(BorderStyle.THIN);
	  cellStyle.setBorderRight(BorderStyle.THIN);
	  cellStyle.setBorderTop(BorderStyle.THIN);
	  cellStyle.setAlignment(HorizontalAlignment.CENTER);
	  cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
	  Font font=workbook.createFont();
	  font.setBold(true);
	  cellStyle.setFont(font);
	  cell=row.getCell(column);
	  if(cell==null) {
		  cell=row.createCell(column);
		  
	  }
	  if(cell!=null) {
		  cell.setCellStyle(cellStyle);
	  }
	  cellStyle=null;
	  return cell;
   }
   public XSSFCell createMyBoldCell(XSSFRow row, int column) {
	   XSSFCell cell=null;
	   XSSFCellStyle cellStyle=workbook.createCellStyle();
	   cellStyle.setBorderBottom(BorderStyle.THIN);
		  cellStyle.setBorderLeft(BorderStyle.THIN);
		  cellStyle.setBorderRight(BorderStyle.THIN);
		  cellStyle.setBorderTop(BorderStyle.THIN);
		  cellStyle.setAlignment(HorizontalAlignment.LEFT);
	   Font font=workbook.createFont();
	   font.setBold(true);
	   cellStyle.setFont(font);
	   cell=row.getCell(column);
	   if(cell==null) {
			cell=row.createCell(column);
			  
	   }
	   if(cell!=null) {
		   cell.setCellStyle(cellStyle);
	   }
	   cellStyle=null;
	   return cell;
   }
   public XSSFCell createCenterCell(XSSFRow row,int column) {
		  XSSFCell cell=null;
		  XSSFCellStyle cellStyle=workbook.createCellStyle();
		  cellStyle.setAlignment(HorizontalAlignment.CENTER);
		  cellStyle.setBorderBottom(BorderStyle.THIN);
		  cellStyle.setBorderLeft(BorderStyle.THIN);
		  cellStyle.setBorderRight(BorderStyle.THIN);
		  cellStyle.setBorderTop(BorderStyle.THIN);
		  cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		  cellStyle.setWrapText(true);
		  cell=row.getCell(column);
		  if(cell==null) {
			  cell=row.createCell(column);
			  
		  }
		  if(cell!=null) {
			  cell.setCellStyle(cellStyle);
		  }
		  cellStyle=null;
		  return cell;
	   }
public XSSFWorkbook getWorkbook() {
	return workbook;
}
public void setWorkbook(XSSFWorkbook workbook) {
	this.workbook = workbook;
}
public File getOutputFile() {
	return outputFile;
}
public void setOutputFile(File outputFile) {
	this.outputFile = outputFile;
}
   
    

}
